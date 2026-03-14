package TestJava.Test191;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// 1. Defining the annotations
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
@interface Component {}

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD)
@interface Autowired {}

// 2. Creating some services
@Component
class EmailService {
    public void sendEmail(String to) { System.out.println("Email sent to: " + to); }
}

@Component
class UserService {
    // We want the framework to inject this!
    @Autowired
    public EmailService emailService;
    
    public void registerUser(String username) {
        System.out.println("User registered: " + username);
        emailService.sendEmail(username + "@example.com");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 191: @Component and @Autowired ===\n");

        System.out.println("In Spring, you never use 'new'. The framework creates the objects");
        System.out.println("(@Component) and wires them together (@Autowired) using Reflection.\n");

        System.out.println("--- Simulating Spring ApplicationContext ---");
        
        // 1. Framework creates the instances
        EmailService emailInstance = new EmailService();
        UserService userInstance = new UserService();
        
        System.out.println("Beans created. Now performing Dependency Injection...");
        
        // 2. Framework injects the dependencies! (Reading @Autowired)
        Class<?> clazz = userInstance.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                
                // If the field type is EmailService, inject our instance!
                if (field.getType() == EmailService.class) {
                    field.setAccessible(true);
                    field.set(userInstance, emailInstance);
                    System.out.println("[DI Success] Injected " + field.getType().getSimpleName() + " into " + clazz.getSimpleName());
                }
            }
        }
        
        System.out.println("\n--- Testing the fully wired Object ---");
        userInstance.registerUser("vikas");
    }
}
