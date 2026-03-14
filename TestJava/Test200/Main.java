package TestJava.Test200;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
@interface Cacheable {}

interface MathService {
    @Cacheable
    int computeHeavyMath(int input);
}

class MathServiceImpl implements MathService {
    @Override
    public int computeHeavyMath(int input) {
        System.out.println("   [Business Logic] Calculating intensely for: " + input);
        try { Thread.sleep(1000); } catch (Exception e) {} // Pretend it's hard
        return input * input;
    }
}

// Interceptor representing @Around advice! It stops the execution entirely if cache hits.
class CacheAspect implements InvocationHandler {
    private final Object target;
    // VERY simple static cache for the proxy
    private final java.util.Map<Integer, Integer> cache = new java.util.HashMap<>();

    public CacheAspect(Object target) { this.target = target; }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        
        // If it's @Cacheable, INTERCEPT!
        if (realMethod.isAnnotationPresent(Cacheable.class)) {
            int input = (int) args[0]; // Assuming one parameter for simplicity
            
            System.out.println("\n[AOP Cache Check] Asking for input: " + input);
            if (cache.containsKey(input)) {
                System.out.println("[AOP HIT] Returning from cache instantly!");
                return cache.get(input); // We don't even call method.invoke() !
            }
            
            System.out.println("[AOP MISS] Invoking real method...");
            Object result = method.invoke(target, args); // Run the real thing
            cache.put(input, (int) result); // Save the result
            return result;
        }

        // If not annotated, just pass through
        return method.invoke(target, args);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 200: AOP Method Interceptors (@Around / @Cacheable) ===\n");

        System.out.println("Some AOP Interceptors (like @Around) can completely stop the original");
        System.out.println("method from executing, which is perfect for features like @Cacheable!\n");

        MathService service = (MathService) Proxy.newProxyInstance(
                MathService.class.getClassLoader(),
                new Class[]{MathService.class},
                new CacheAspect(new MathServiceImpl())
        );

        System.out.println("1st call for 5:");
        System.out.println("Result: " + service.computeHeavyMath(5));

        System.out.println("\n2nd call for 5 (Should be instant):");
        System.out.println("Result: " + service.computeHeavyMath(5));

        System.out.println("\nCall for 10:");
        System.out.println("Result: " + service.computeHeavyMath(10));
    }
}
