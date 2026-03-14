package TestJava.Test187;

import java.util.HashMap;
import java.util.Map;

// Simulating how Hibernate caches the INITIAL state of objects to detect changes!
class EntityManagerMock {
    
    // A snapshot of objects as they were when they were first loaded from the DB
    private Map<Object, String> snapshots = new HashMap<>();

    public void trackEntity(Object entity) {
        // Serialize or clone the object to keep its initial state
        snapshots.put(entity, entity.toString());
    }

    public void flush(Object entity) {
        String initialState = snapshots.get(entity);
        String currentState = entity.toString();

        if (initialState == null) {
            System.out.println("Entity is New! Executing HTTP INSERT...");
        } else if (!initialState.equals(currentState)) {
            System.out.println("Dirty Checking: Object state changed!");
            System.out.println("From: " + initialState);
            System.out.println("To  : " + currentState);
            System.out.println("Executing SQL UPDATE...");
        } else {
            System.out.println("Dirty Checking: No changes detected. No SQL needed!");
        }
    }
}

class Product {
    public int id;
    public double price;
    
    public Product(int id, double price) { this.id = id; this.price = price; }
    
    @Override
    public String toString() { return "Product{id=" + id + ", price=" + price + "}"; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 187: Dirty Checking Concept ===\n");

        System.out.println("Hibernate doesn't immediately send UPDATEs. It waits until 'flush()' or commit,");
        System.out.println("compares the current objects to their original snapshot, and ONLY updates if 'Dirty'!\n");

        EntityManagerMock em = new EntityManagerMock();

        // 1. Load an object (Simulate DB read)
        Product laptop = new Product(101, 1500.0);
        em.trackEntity(laptop); // Snapshot saved

        // 2. User modifies the object
        System.out.println("Saving laptop without making changes...");
        em.flush(laptop); // Nothing happens
        
        System.out.println("\nUser updates the price...");
        laptop.price = 1400.0;
        
        System.out.println("Saving laptop again...");
        em.flush(laptop); // Detects difference! Sends UPDATE
    }
}
