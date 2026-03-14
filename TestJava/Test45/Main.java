package TestJava.Test45;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// CyclicBarrier allows a set of threads to all wait for each other to reach a common barrier point.
// Unlike CountDownLatch, a CyclicBarrier can be REUSED after the waiting threads are released!
// Example: 3 hikers climbing a mountain. They all agree to wait at the checkpoint 
// before proceeding to the summit together.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== CyclicBarrier Tutorial ===");

        // We need 3 threads to reach the barrier before they can proceed.
        // We can also provide a runnable that executes WHEN the barrier is tripped!
        CyclicBarrier checkpoint = new CyclicBarrier(3, () -> {
            System.out.println(">>> CHECKPOINT REACHED! Everyone is here! Proceeding to the next phase...\n");
        });

        for (int i = 1; i <= 3; i++) {
            String hikerName = "Hiker-" + i;
            new Thread(() -> {
                try {
                    System.out.println(hikerName + " is climbing Phase 1...");
                    Thread.sleep((long) (Math.random() * 1500));
                    System.out.println(hikerName + " arrived at the Checkpoint. Waiting for others...");
                    
                    // The thread STOPS here and waits.
                    checkpoint.await(); 

                    // This code only runs after ALL 3 hikers have called await()
                    System.out.println(hikerName + " is climbing Phase 2 (Summit)...");
                    
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
