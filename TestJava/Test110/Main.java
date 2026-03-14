package TestJava.Test110;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Structured Concurrency (Simulation / Alternative) ===\n");

        System.out.println("Structured Concurrency is currently a Java Preview Feature (as of Java 21).");
        System.out.println("Because it requires `--enable-preview`, we will simulate its core concept here using modern alternatives.\n");
        
        // Core Idea: When splitting a task into concurrent subtasks, they should all return to the same lexical scope.
        // If one subtask fails, the others should be cancelled to prevent leaking threads!

        System.out.println("Imagine a user profile page that fetches Data, Friends List, and Recent Posts simultaneously.");
        
        try {
            // Simulated Structured Fetch
            fetchUserProfileAggregated();
        } catch (Exception e) {
            System.err.println("Main Error: " + e.getMessage());
        }
    }

    private static void fetchUserProfileAggregated() throws Exception {
        // Since we can't reliably use `StructuredTaskScope` here, we simulate it.
        // In real Structured Concurrency, if 'fetchFriends' threw an exception,
        // the scope would AUTOMATICALLY cancel 'fetchData'!
        
        long start = System.currentTimeMillis();

        // We launch 3 detached futures
        var fetchData = new FutureTask<>(() -> {
            Thread.sleep(500);
            return "User: Vikas";
        });
        
        var fetchFriends = new FutureTask<>(() -> {
            Thread.sleep(700);
            return "Friends: Async, Java, AI";
        });
        
        var fetchPosts = new FutureTask<String>(() -> {
            Thread.sleep(200);
            throw new RuntimeException("Database error loading posts!");
        });

        Thread t1 = new Thread(fetchData);
        Thread t2 = new Thread(fetchFriends);
        Thread t3 = new Thread(fetchPosts);
        
        t1.start(); t2.start(); t3.start();

        try {
            // In pure Structured Concurrency, this blocking phase is cleaner 
            // and guarantees no orphaned threads if an exception happens!
            String data = fetchData.get();
            String posts = fetchPosts.get(); // This will throw!
            String friends = fetchFriends.get();
            
            System.out.println("Result: " + data + " | " + friends + " | " + posts);
            
        } catch (ExecutionException e) {
            System.out.println("A subtask failed! Cancelling the entire operation.");
            // Manual cancellation (StructuredTaskScope does this automatically)
            fetchData.cancel(true);
            fetchFriends.cancel(true);
            throw new Exception("Profile Fetch Failed because: " + e.getCause().getMessage());
        } finally {
            System.out.println("Operation finished in " + (System.currentTimeMillis() - start) + "ms");
            System.out.println("Concept: Structured Concurrency ensures error propagation and prevents thread leaks!");
        }
    }
}
