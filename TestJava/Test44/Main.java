package TestJava.Test44;

import java.util.concurrent.CountDownLatch;

// CountDownLatch allows one or more threads to wait until a set of operations 
// being performed in other threads completes.
// Example: A main application thread waiting for 3 background services to initialize.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== CountDownLatch Tutorial ===");
        
        // We need exactly 3 services to start before we can proceed
        CountDownLatch latch = new CountDownLatch(3);

        System.out.println("Main Application starting... Waiting for services to initialize.");

        // Start 3 fake services
        for (int i = 1; i <= 3; i++) {
            String serviceName = "Service-" + i;
            new Thread(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println(serviceName + " initialized.");
                } catch (InterruptedException e) {} 
                finally {
                    // Decrement the latch. Once it hits 0, it releases all waiting threads!
                    latch.countDown(); 
                }
            }).start();
        }

        // The MAIN thread pauses here until latch reaches 0
        latch.await(); 
        
        System.out.println("All services are up! Main Application is now fully running.");
    }
}
