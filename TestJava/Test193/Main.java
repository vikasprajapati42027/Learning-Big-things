package TestJava.Test193;

import java.util.HashMap;
import java.util.Map;

// Mocking standard components
class LoggerService { 
    public LoggerService() { System.out.println("LoggerService Initialized!"); }
}

class AuthService { 
    public AuthService() { System.out.println("AuthService Initialized!"); }
}

// The core engine of Spring!
class MiniBeanFactory {
    // Key: Class Type, Value: The Single Instance
    private final Map<Class<?>, Object> singletonRegistry = new HashMap<>();

    public void registerBean(Class<?> clazz) throws Exception {
        if (!singletonRegistry.containsKey(clazz)) {
            // Instantiate using Reflection
            Object instance = clazz.getDeclaredConstructor().newInstance();
            singletonRegistry.put(clazz, instance);
        }
    }

    // Generic method to magically retrieve a bean!
    public <T> T getBean(Class<T> clazz) {
        Object bean = singletonRegistry.get(clazz);
        if (bean == null) {
            throw new RuntimeException("No bean of type " + clazz.getName() + " found!");
        }
        return (T) bean; // Type-safe casting
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 193: Mini BeanFactory (Singleton Registry) ===\n");

        MiniBeanFactory factory = new MiniBeanFactory();
        
        System.out.println("--- Starting up ApplicationContext ---");
        // Spring does this automatically after scanning
        factory.registerBean(LoggerService.class);
        factory.registerBean(AuthService.class);
        
        System.out.println("\n--- Application Running - Requesting Beans ---");
        
        // Retrieve beans just like Spring's context.getBean()
        LoggerService logger1 = factory.getBean(LoggerService.class);
        LoggerService logger2 = factory.getBean(LoggerService.class);
        
        System.out.println("Retrieved Logger 1: " + logger1);
        System.out.println("Retrieved Logger 2: " + logger2);
        
        System.out.println("\nAre they the exact same instance in memory? (Singleton Pattern): " + (logger1 == logger2));
    }
}
