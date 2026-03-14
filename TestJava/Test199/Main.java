package TestJava.Test199;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
@interface Transactional {}

interface UserService {
    @Transactional
    void createUser(String username);
    void readUser(int id);
}

class UserServiceImpl implements UserService {
    @Override
    public void createUser(String username) {
        System.out.println("   [Business Logic] INSERT INTO users VALUES ('" + username + "')");
        if (username.equals("evil_hacker")) {
            throw new RuntimeException("DB Exception: Invalid Name!");
        }
    }

    @Override
    public void readUser(int id) {
        System.out.println("   [Business Logic] SELECT * FROM users WHERE id = " + id);
    }
}

// The magical Proxy that intercepts method calls!
class TransactionAspect implements InvocationHandler {
    private final Object target;

    public TransactionAspect(Object target) { this.target = target; }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean isTransactional = false;
        
        // Reflection magic: Does the original method have @Transactional?
        Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (realMethod.isAnnotationPresent(Transactional.class)) {
            isTransactional = true;
            System.out.println("\n[AOP] @Transactional detected. BEGIN TRANSACTION;");
        }

        try {
            Object result = method.invoke(target, args); // Run the actual method!
            if (isTransactional) {
                System.out.println("[AOP] Success. COMMIT TRANSACTION;\n");
            }
            return result;
            
        } catch (Exception e) {
            if (isTransactional) {
                System.out.println("[AOP] Exception caught! ROLLBACK TRANSACTION; \n");
            }
            throw e; // Rethrow to the user
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 199: Dynamic Proxy for @Transactional ===\n");

        System.out.println("This is EXACTLY how Spring's @Transactional works!");
        System.out.println("It wraps your service in a proxy that intercepts calls and starts DB transactions.\n");

        UserService realService = new UserServiceImpl();
        UserService transactionalProxy = (UserService) Proxy.newProxyInstance(
                UserService.class.getClassLoader(),
                new Class[]{UserService.class},
                new TransactionAspect(realService)
        );

        System.out.println("--- 1. Calling standard method (No @Transactional) ---");
        transactionalProxy.readUser(1); // No transaction output!
        
        System.out.println("\n--- 2. Calling @Transactional method (Success) ---");
        transactionalProxy.createUser("vikas"); // Transaction handled!

        System.out.println("--- 3. Calling @Transactional method (Failure) ---");
        try {
            transactionalProxy.createUser("evil_hacker"); // Triggers Rollback!
        } catch (Exception e) {}
    }
}
