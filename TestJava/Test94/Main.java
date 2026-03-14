package TestJava.Test94;

public class Main {
    // Two shared resources (Locks)
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Deadlock Simulation & Prevention ===\n");

        // Deadlocks happen when Thread A holds Lock 1 and wants Lock 2,
        // while Thread B holds Lock 2 and wants Lock 1.

        System.out.println("Starting threads... This script is designed to finish gracefully, not actually lock forever!");

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Acquired SystemA Lock.");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for SystemB Lock...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired Both Locks! Success!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            // HOW TO PREVENT DEADLOCKS:
            // The golden rule is "Lock Ordering".
            // If ALL threads acquire locks in the EXACT SAME ORDER (e.g., always Lock1 then Lock2),
            // a deadlock is mathematically impossible!
            
            // To see a deadlock, change 'lock1' below to 'lock2', and 'lock2' to 'lock1'.
            synchronized (lock1) { // Same order as Thread 1!
                System.out.println("Thread 2: Acquired SystemA Lock.");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for SystemB Lock...");
                synchronized (lock2) {
                    System.out.println("Thread 2: Acquired Both Locks! Success!");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        
        System.out.println("\nExecution completed without freezing because we enforced Lock Ordering!");
    }
}
