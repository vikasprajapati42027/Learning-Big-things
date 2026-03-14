package TestJava.Test109;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Virtual Threads Preview Concept (Project Loom) ===\n");

        // "Platform Threads" map 1:1 to OS Threads. They are heavy. A machine can only handle a few thousand.
        // "Virtual Threads" (Java 21+) are managed entirely by the JVM. A machine can handle MILLIONS of them!
        
        System.out.println("In Java 17, we use standard Thread Pools. Let's run a small workload.");
        
        int taskCount = 1000; // Small batch so we don't crash Java 17 with actual OS threads
        AtomicInteger completedTasks = new AtomicInteger(0);

        long startTime = System.currentTimeMillis();

        // Standard OS-bound Thread Pool
        try (ExecutorService executor = Executors.newFixedThreadPool(100)) {
            for (int i = 0; i < taskCount; i++) {
                executor.submit(() -> {
                    try {
                        Thread.sleep(10); // Simulate blocking work
                    } catch (InterruptedException e) {}
                    completedTasks.incrementAndGet();
                });
            }
            executor.shutdown();
        }

        long endTime = System.currentTimeMillis();
        
        System.out.println("Successfully executed " + completedTasks.get() + " tasks using Platform Threads.");
        System.out.println("Time Taken: " + (endTime - startTime) + "ms");
        
        System.out.println("\nNote: In Java 21+, you can replace Executors.newFixedThreadPool(...) with:");
        System.out.println("Executors.newVirtualThreadPerTaskExecutor()");
        System.out.println("This allows running millions of blocking tasks simultaneously without OutOfMemoryError!");
    }
}
