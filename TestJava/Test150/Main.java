package TestJava.Test150;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

// --- A Simple Record to represent Data ---
record ProcessedResult(int id, String status, LocalDateTime time) {}

// --- A Singleton Service ---
enum EngineSupervisor {
    INSTANCE;
    public void log(String msg) {
        System.out.println("[Supervisor] " + Thread.currentThread().getName() + " -> " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      TEST 150: THE ULTIMATE JAVA ARCHITECT      ");
        System.out.println("=================================================\n");

        System.out.println("Combining Modern Features: Streams, Structured Concurrency Concepts, Records, Optionals, and Singletons!\n");

        // 1. Thread Pool (Virtual Threads in Java 21, but we use a fixed pool here for compatibility)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Dispatching 5 complex async tasks...\n");

        // 2. Parallel Processing and Futures
        var futures = IntStream.rangeClosed(1, 5)
            .mapToObj(id -> CompletableFuture.supplyAsync(() -> processData(id), executor))
            .toList();

        // 3. Wait for all to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        // 4. Stream over the results
        System.out.println("\n--- Final Aggregated Results ---");
        
        long successes = futures.stream()
            // 5. safely extract the result (No NullPointerExceptions!)
            .map(CompletableFuture::join) 
            // 6. Print using Records
            .peek(result -> System.out.println("Result Record: " + result))
            // 7. Filter
            .filter(r -> "SUCCESS".equals(r.status()))
            .count();

        System.out.println("\nTotal Successful Operations: " + successes);
        System.out.println("\nJava Concept Tutorials (Test1 to Test150) Completed Successfully!");
        
        executor.shutdown();
    }

    // A mock method representing complex business logic
    private static ProcessedResult processData(int id) {
        EngineSupervisor.INSTANCE.log("Starting task " + id);
        
        try {
            // Simulate work
            Thread.sleep(100 * id); 
            
            // Artificial failure
            if (id == 4) {
                throw new RuntimeException("Simulated Database Timeout!");
            }
            
            EngineSupervisor.INSTANCE.log("Finished task " + id);
            return new ProcessedResult(id, "SUCCESS", LocalDateTime.now());
            
        } catch (Exception e) {
            EngineSupervisor.INSTANCE.log("FAILED task " + id + " - " + e.getMessage());
            return new ProcessedResult(id, "FAILED", LocalDateTime.now());
        }
    }
}
