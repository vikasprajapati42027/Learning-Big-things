package TestJava.Test91;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ScheduledExecutorService Tutorial ===\n");

        // Better than java.util.Timer! It uses a thread pool and handles exceptions gracefully.
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        System.out.println("App started at: " + LocalTime.now());

        // 1. Run ONCE after a delay
        scheduler.schedule(() -> {
            System.out.println(">>> [Alert] One-time task executed at: " + LocalTime.now());
        }, 2, TimeUnit.SECONDS);

        // 2. Run REPEATEDLY at a Fixed Rate (Starts new execution every X seconds, regardless of how long previous task took)
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("+++ [Heartbeat] Fixed Rate Ping at: " + LocalTime.now());
            try { Thread.sleep(500); /* Simulate work */ } catch (InterruptedException e) {}
        }, 1, 2, TimeUnit.SECONDS); // Initial delay 1s, repeat every 2s

        // 3. Run REPEATEDLY with a Fixed Delay (Waits X seconds AFTER the previous task FINISHES before starting the next)
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("--- [Cleanup] Fixed Delay Task at: " + LocalTime.now());
            try { Thread.sleep(1000); /* Simulate heavy work */ } catch (InterruptedException e) {}
        }, 1, 2, TimeUnit.SECONDS);

        
        // Let them run for a bit
        Thread.sleep(8000);
        
        System.out.println("\nShutting down scheduler...");
        scheduler.shutdown(); // Stops accepting new tasks
        
        // Block until tasks finish or timeout occurs
        if (scheduler.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("Scheduler shut down cleanly.");
        } else {
            System.out.println("Forcing shutdown!");
            scheduler.shutdownNow();
        }
    }
}
