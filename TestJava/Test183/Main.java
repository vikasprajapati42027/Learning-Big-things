package TestJava.Test183;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
@interface Entity {}

// Some fake classes in our "project"
@Entity class Customer {}
@Entity class Order {}
class DatabaseHelper {} // Not an entity!

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 183: Reflection Entity Scanner ===\n");

        System.out.println("How does Hibernate know which classes are Entities without you telling it?");
        System.out.println("It aggressively scans the Classpath (all loaded .class files) looking for @Entity!\n");

        // Simulating a Classpath Scanner
        // In reality, libraries like 'Reflections' or Spring 'ClassPathScanningCandidateComponentProvider' do this.
        List<Class<?>> allClassesInProject = List.of(
            Customer.class, Order.class, DatabaseHelper.class, Main.class
        );
        
        List<Class<?>> entityClasses = new ArrayList<>();
        
        System.out.println("Scanning complete classpath...");
        for (Class<?> clazz : allClassesInProject) {
            if (clazz.isAnnotationPresent(Entity.class)) {
                entityClasses.add(clazz);
                System.out.println("[Found Entity] -> " + clazz.getName());
            } else {
                System.out.println("[Ignored]      -> " + clazz.getName());
            }
        }
        
        System.out.println("\nORM Framework successfully bootstrapped with " + entityClasses.size() + " tables to manage!");
    }
}
