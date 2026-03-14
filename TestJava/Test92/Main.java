package TestJava.Test92;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Callable & Future Tutorial ===\n");

        ExecutorService pool = Executors.newSingleThreadExecutor();

        // Runnable: public void run() -> Returns NOTHING and cannot throw checked exceptions.
        // Callable: public T call() throws Exception -> Returns a Result AND handles exceptions!
        
        Callable<String> expensiveTask = () -> {
            System.out.println("[Thread] Starting heavy computation...");
            Thread.sleep(3000); // 3 seconds of "work"
            return "Financial Report Generated Successfully!";
        };

        System.out.println("[Main] Submitting task to pool...");
        // A Future is a "promise" or a box that will EVENTUALLY hold the result of the Callable.
        Future<String> futureResult = pool.submit(expensiveTask);

        System.out.println("[Main] Task submitted. Doing other stuff while waiting...");

        try {
            // 1. isDone() checks if it finished
            if (!futureResult.isDone()) {
                System.out.println("[Main] Still waiting...");
            }

            // 2. get() BLOCKS the main thread until the result is ready!
            System.out.println("[Main] Calling get() now (Blocking...)");
            
            // You can also use get(timeout, TimeUnit) to avoid hanging forever!
            String report = futureResult.get(5, TimeUnit.SECONDS); 
            
            System.out.println("[Main] Got Result: " + report);

        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while waiting!");
        } catch (ExecutionException e) {
            System.out.println("The Callable threw an exception! " + e.getCause());
        } catch (TimeoutException e) {
            System.out.println("Task took too long to complete!");
            futureResult.cancel(true); // Attempt to interrupt the thread processing the task
        } finally {
            pool.shutdown();
        }
    }
}
