package TestJava.Test22;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Concurrent Collections Tutorial ===");

        // 1. ConcurrentHashMap
        // Unlike a regular HashMap (which breaks in multithreading) or a Hashtable (which is slow due to heavy locks),
        // ConcurrentHashMap uses "Lock Striping" - it only locks the specific segment of the map being updated!
        System.out.println("\n--- 1. ConcurrentHashMap ---");
        Map<String, Integer> inventory = new ConcurrentHashMap<>();
        inventory.put("Laptops", 100);

        Runnable worker1 = () -> {
            for (int i = 0; i < 50; i++) {
                // computeIfPresent is an atomic operation! No external synchronization needed.
                inventory.computeIfPresent("Laptops", (key, val) -> val - 1);
            }
        };

        Runnable worker2 = () -> {
            for (int i = 0; i < 40; i++) {
                inventory.computeIfPresent("Laptops", (key, val) -> val - 1);
            }
        };

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final Laptop Inventory (Should be 10): " + inventory.get("Laptops"));

        // 2. CopyOnWriteArrayList
        // Great for lists that are read OFTEN but written to RARELY.
        // Every time an element is added, an entire copy of the underlying array is created.
        System.out.println("\n--- 2. CopyOnWriteArrayList ---");
        List<String> activeUsers = new CopyOnWriteArrayList<>();
        activeUsers.add("UserA");
        activeUsers.add("UserB");

        Runnable reader = () -> {
            // We can iterate over this list cleanly even if another thread is adding to it!
            // A regular ArrayList would throw a ConcurrentModificationException here.
            for (String user : activeUsers) {
                System.out.println("Reading active user: " + user);
                try { Thread.sleep(50); } catch (Exception e) {}
            }
        };

        Runnable writer = () -> {
            try { Thread.sleep(20); } catch (Exception e) {}
            activeUsers.add("UserC");
            System.out.println("Added UserC to the active list!");
        };

        Thread t3 = new Thread(reader);
        Thread t4 = new Thread(writer);
        t3.start(); t4.start();
        t3.join(); t4.join();
        
        System.out.println("Final Active Users List: " + activeUsers);
    }
}
