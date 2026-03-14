package TestJava.Test196;

import java.util.HashSet;
import java.util.Set;

// Circular Dependency: BeanA needs BeanB, and BeanB needs BeanA!
class BeanA {
    public BeanB b;
    public BeanA(BeanB b) { this.b = b; }
}

class BeanB {
    public BeanA a;
    public BeanB(BeanA a) { this.a = a; }
}

// A smart Factory that detects infinite loops!
class SmartBeanFactory {
    // Keeps track of beans currently IN THE PROCESS of being created
    private Set<String> currentlyCreating = new HashSet<>();

    public void createBeanA() {
        String beanName = "BeanA";
        
        if (currentlyCreating.contains(beanName)) {
            throw new RuntimeException("Circular Dependency Detected! BeanA -> BeanB -> BeanA");
        }
        
        currentlyCreating.add(beanName);
        System.out.println("Started creating BeanA...");
        
        // Simulating the attempt to resolve its dependencies
        System.out.println("BeanA needs BeanB, trying to create BeanB...");
        createBeanB(); 
        
        currentlyCreating.remove(beanName);
        System.out.println("Finished creating BeanA.");
    }

    public void createBeanB() {
        String beanName = "BeanB";
        
        if (currentlyCreating.contains(beanName)) {
            throw new RuntimeException("Circular Dependency Detected! BeanB -> BeanA -> BeanB");
        }
        
        currentlyCreating.add(beanName);
        System.out.println("Started creating BeanB...");
        
        // Simulating the attempt to resolve its dependencies
        System.out.println("BeanB needs BeanA, trying to create BeanA...");
        createBeanA(); 
        
        currentlyCreating.remove(beanName);
        System.out.println("Finished creating BeanB.");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 196: Detecting Circular Dependencies ===\n");

        System.out.println("Spring Boot throws a 'BeanCurrentlyInCreationException' if two beans");
        System.out.println("require each other via Constructor Injection.\n");

        SmartBeanFactory factory = new SmartBeanFactory();

        try {
            factory.createBeanA();
        } catch (Exception e) {
            System.err.println("\n[ERROR CAUGHT] " + e.getMessage());
            System.out.println("\nPrevention: Use Field/Setter injection, or redesign the architecture using a Mediator!");
        }
    }
}
