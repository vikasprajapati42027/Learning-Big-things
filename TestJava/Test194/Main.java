package TestJava.Test194;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class Dependency {
    public void doWork() { System.out.println("Dependency doing work..."); }
}

// Approach 1: Field Injection (Not recommended by modern Spring)
class FieldInjectionService {
    public Dependency dependency; // Will be injected via reflection
}

// Approach 2: Constructor Injection (Highly recommended!)
class ConstructorInjectionService {
    public final Dependency dependency; // 'final' ensures immutability!

    public ConstructorInjectionService(Dependency dependency) {
        this.dependency = dependency;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 194: Constructor vs Field Injection ===\n");

        System.out.println("Spring recommends Constructor Injection over Field (@Autowired) Injection");
        System.out.println("because it allows immutable 'final' fields and easier testing!\n");

        Dependency myDep = new Dependency();

        System.out.println("--- Simulating Framework Field Injection ---");
        FieldInjectionService fieldSvc = new FieldInjectionService();
        Field field = FieldInjectionService.class.getDeclaredField("dependency");
        field.setAccessible(true);
        field.set(fieldSvc, myDep); // Violates encapsulation
        fieldSvc.dependency.doWork();

        System.out.println("\n--- Simulating Framework Constructor Injection ---");
        // The framework looks at the constructor parameters and passes them dynamically!
        Constructor<ConstructorInjectionService> constructor = ConstructorInjectionService.class.getConstructor(Dependency.class);
        ConstructorInjectionService constructorSvc = constructor.newInstance(myDep); // Clean!
        constructorSvc.dependency.doWork();
        
        System.out.println("\nWhy constructor is better: The object cannot be instantiated in an invalid state.");
    }
}
