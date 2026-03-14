package TestJava.Test23;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    // 1. The Volatile Keyword
    // 'volatile' guarantees that any thread reading this variable will see the MOST RECENT write.
    // It prevents threads from caching the variable in their local CPU registers.
    // However, it does NOT make operations atomic (e.g., flag = !flag is not safe).
    private static volatile boolean keepRunning = true;

    // 2. Atomic Variables
    // These use low-level CPU instructions (Compare-And-Swap) to update values atomically
    // WITHOUT needing the expensive 'synchronized' keyword.
    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    private static int regularCounter = 0; // Will experience race conditions!

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Atomic Variables & Volatile Tutorial ===");

        // --- Demo 1: Volatile flag ---
        System.out.println("\n--- 1. Volatile Flag ---");
        Thread backgroundWorker = new Thread(() -> {
            System.out.println("Background worker started. Waiting for flag to turn false...");
            while (keepRunning) {
                // If 'keepRunning' wasn't volatile, this thread might cache it as 'true'
                // and loop infinitely, even after Main thread changes it to 'false'!
            }
            System.out.println("Background worker detected the change and is stopping!");
        });

        backgroundWorker.start();
        Thread.sleep(100); // Give worker time to start
        System.out.println("Main thread changing the flag to false...");
        keepRunning = false; // The volatile keyword ensures the worker sees this instantly!
        backgroundWorker.join();

        // --- Demo 2: AtomicInteger vs int ---
        System.out.println("\n--- 2. AtomicInteger vs Regular int ---");
        
        Runnable raceTask = () -> {
            for (int i = 0; i < 1000; i++) {
                regularCounter++; // NOT THREAD SAFE (Read -> Add -> Write)
                atomicCounter.incrementAndGet(); // THREAD SAFE (Single atomic CPU operation!)
            }
        };

        Thread t1 = new Thread(raceTask);
        Thread t2 = new Thread(raceTask);
        Thread t3 = new Thread(raceTask);

        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join(); t3.join();

        System.out.println("Target Count  : 3000");
        System.out.println("Regular int   : " + regularCounter + " (Likely corrupted/missed counts)");
        System.out.println("AtomicInteger : " + atomicCounter.get() + " (Always perfect!)");
    }
}
