package TestJava.Test195;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

// Simulating @Scope("prototype")
@Retention(RetentionPolicy.RUNTIME)
@interface Scope { String value() default "singleton"; }

@Scope("singleton") // Default
class DatabaseConnection {}

@Scope("prototype") // Create a NEW instance every time!
class StateMachine {}

class ScopedBeanFactory {
    private Map<Class<?>, Object> singletonCache = new HashMap<>();

    public <T> T getBean(Class<T> clazz) throws Exception {
        
        Scope scopeMeta = clazz.getAnnotation(Scope.class);
        boolean isPrototype = (scopeMeta != null && scopeMeta.value().equals("prototype"));

        if (isPrototype) {
            System.out.println("[Factory] Creating a BRAND NEW instance of " + clazz.getSimpleName());
            return clazz.getDeclaredConstructor().newInstance();
        } else {
            // Singleton Logic
            if (!singletonCache.containsKey(clazz)) {
                System.out.println("[Factory] Creating Singleton instance of " + clazz.getSimpleName());
                singletonCache.put(clazz, clazz.getDeclaredConstructor().newInstance());
            } else {
                System.out.println("[Factory] Returning cached Singleton for " + clazz.getSimpleName());
            }
            return (T) singletonCache.get(clazz);
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 195: Bean Scopes (@Scope Prototype vs Singleton) ===\n");

        ScopedBeanFactory factory = new ScopedBeanFactory();

        System.out.println("--- Requesting DatabaseConnection (Singleton) ---");
        DatabaseConnection db1 = factory.getBean(DatabaseConnection.class);
        DatabaseConnection db2 = factory.getBean(DatabaseConnection.class);
        System.out.println("db1 == db2? " + (db1 == db2)); // True!

        System.out.println("\n--- Requesting StateMachine (Prototype) ---");
        StateMachine sm1 = factory.getBean(StateMachine.class);
        StateMachine sm2 = factory.getBean(StateMachine.class);
        System.out.println("sm1 == sm2? " + (sm1 == sm2)); // False!
    }
}
