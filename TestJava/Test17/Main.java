package TestJava.Test17;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CompletableFuture (Async) Tutorial ===");
        System.out.println("Main thread started: " + Thread.currentThread().getName());

        // 1. runAsync: Run a background task without returning a value
        System.out.println("\n--- 1. runAsync ---");
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            sleep(500);
            System.out.println("Background task executing in: " + Thread.currentThread().getName());
        });

        // 2. supplyAsync: Run a background task that RETURNS a value
        System.out.println("\n--- 2. supplyAsync & thenApply ---");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(800);
            return "Raw DB Data";
        }).thenApply(data -> {
            // This runs after supplyAsync finishes successfully
            return data + " -> Processed into JSON";
        });

        // 3. thenAccept: Consume the result of a previous future
        future2.thenAccept(result -> {
            System.out.println("Consumed Result: " + result + " [Thread: " + Thread.currentThread().getName() + "]");
        });

        System.out.println("Main thread is NOT blocked! It prints this immediately while futures run.");

        // 4. Wait for them to finish (otherwise main thread exits before they complete)
        CompletableFuture.allOf(future1, future2).join();
        System.out.println("\nAll asynchronous operations completed.");
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch(Exception e) {}
    }
}
