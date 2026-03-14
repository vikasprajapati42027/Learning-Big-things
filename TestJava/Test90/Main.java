package TestJava.Test90;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

// AtomicLong is great, but under HIGH contention (thousands of threads updating it),
// it suffers from CAS (Compare-And-Swap) retries taking CPU time.
//
// LongAdder (Java 8+) fixes this by maintaining an Array of variables internally,
// allowing threads to update different cells without fighting each other!
// When you call .sum(), it quickly adds the cells together.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== LongAdder & LongAccumulator ===\n");

        AtomicLong genericCounter = new AtomicLong(0);
        LongAdder optimizedCounter = new LongAdder(); // Starts at 0

        int threads = 10;
        int incrementsPerThread = 100_000;
        
        ExecutorService pool = Executors.newFixedThreadPool(threads);

        System.out.println("Starting heavy multithreaded incrementing...\n");

        for (int i = 0; i < threads; i++) {
            pool.submit(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    // Both ensure thread-safe updates
                    genericCounter.incrementAndGet(); // Can be slow under massive contention
                    optimizedCounter.increment(); // Internally routes to a thread-local cell. Much faster!
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(threads + " threads each did " + incrementsPerThread + " increments.");
        System.out.println("AtomicLong Result: " + genericCounter.get());
        
        // Sums up the internal array cells
        System.out.println("LongAdder Result : " + optimizedCounter.sum()); 
        
        System.out.println("\nRule of thumb: Default to LongAdder/DoubleAdder for statistics gathering (like counting requests) under high load! Use Atomic variables for sequence generators.");
    }
}
