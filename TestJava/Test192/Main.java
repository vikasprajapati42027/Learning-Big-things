package TestJava.Test192;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
@interface Component {}

// Classes in the classpath
@Component class PaymentGateway {}
@Component class NotificationService {}
class UtilityHelper {} // Not a component!
@Component class DatabaseConfig {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 192: Reflection Classpath Scanner for DI ===\n");

        System.out.println("How does Spring Boot know about all your @Service, @Controller classes?");
        System.out.println("It uses a Classpath Scanner to index them at startup!\n");

        // Simulating all loaded classes in the JVM for a package
        List<Class<?>> allClasses = List.of(
             PaymentGateway.class, NotificationService.class, UtilityHelper.class, DatabaseConfig.class, Main.class
        );
        
        List<Class<?>> beanDefinitions = new ArrayList<>();
        
        System.out.println("Scanning for @Component...");
        
        for (Class<?> clazz : allClasses) {
            if (clazz.isAnnotationPresent(Component.class)) {
                beanDefinitions.add(clazz);
                System.out.println(" [Registered Bean Definition]: " + clazz.getSimpleName());
            } else {
                System.out.println(" [Ignored]                 : " + clazz.getSimpleName());
            }
        }
        
        System.out.println("\nApplicationContext created. Total Beans to instantiate: " + beanDefinitions.size());
    }
}
