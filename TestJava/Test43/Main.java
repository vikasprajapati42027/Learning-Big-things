package TestJava.Test43;

import java.util.concurrent.Semaphore;

// A Semaphore controls access to a shared resource through the use of a counter.
// If the counter > 0, access is granted. If it is 0, access is denied.
// Example: A parking lot with exactly 3 parking spots.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Semaphore Tutorial ===");
        
        // A parking lot that can hold EXACTLY 3 cars at any given time
        Semaphore parkingLot = new Semaphore(3);

        // We have 6 cars trying to enter
        for (int i = 1; i <= 6; i++) {
            String carName = "Car-" + i;
            new Thread(() -> {
                try {
                    System.out.println(carName + " is trying to enter the parking lot...");
                    
                    // acquire() decreases the permit count. If 0, it WAITS.
                    parkingLot.acquire(); 
                    
                    System.out.println(">>> " + carName + " PARKED. (Available Spots: " + parkingLot.availablePermits() + ")");
                    Thread.sleep(1000); // Simulate parking duration
                    
                    System.out.println("<<< " + carName + " is leaving.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // release() increases the permit count, letting another thread in!
                    parkingLot.release(); 
                }
            }).start();
        }
    }
}
