package TestJava.Test21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ExecutorService & Thread Pools ===");

        // 1. Create a Thread Pool with a fixed number of threads (e.g., 3 workers)
        // Instead of creating 10 separate Threads (which is expensive for the OS),
        // we create 3 threads that will continuously pull tasks from a queue!
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("\n--- Submitting 5 Tasks to a Pool of 3 Threads ---");
        
        // Let's submit 5 tasks. 
        // 3 tasks will start immediately. 
        // 2 tasks will wait in the queue until a thread becomes free.
        for (int i = 1; i <= 5; i++) {
            executor.execute(new MathTask("Task-" + i));
        }

        // 2. Shut down the executor.
        // It won't accept new tasks, but it WILL finish the currently queued ones.
        executor.shutdown();

        // 3. Wait for all tasks to finish (with a timeout of 10 seconds)
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Tasks took too long. Forcing shutdown.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("\nAll tasks in the ExecutorService have completed.");
    }
}
