package TestJava.Test95;

// Simply calling thread.stop() is deprecated because it instantly kills the thread,
// potentially leaving data corrupted (like a half-written file).
// The CORRECT way to stop a thread is by "Interrupting" it.

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Thread Interruption Tutorial ===\n");

        Thread worker = new Thread(() -> {
            System.out.println("Worker started processing data...");
            try {
                for (int i = 1; i <= 10; i++) {
                    // Check if someone asked us to stop
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Worker: I see I'm interrupted! Cleaning up and stopping gracefully.");
                        return; // Exit the loop and thread
                    }
                    
                    System.out.println("Processing chunk " + i);
                    // sleep() throws InterruptedException if interrupted while sleeping!
                    Thread.sleep(1000); 
                }
            } catch (InterruptedException e) {
                // If sleep() or wait() is interrupted, it throws an exception and 
                // CLEARS the interrupted flag!
                System.out.println("Worker: Interrupted during sleep! Graceful shutdown initiated.");
                
                // Best practice: Restore the interrupted flag in case callers higher up need to know.
                Thread.currentThread().interrupt();
            }
        });

        worker.start();
        
        // Let it work for 3 seconds
        Thread.sleep(3000);
        
        System.out.println("\nMain thread requesting Worker to stop immediately!");
        // We do NOT use worker.stop()! We use .interrupt()
        worker.interrupt();
        
        worker.join();
        System.out.println("Main thread terminating.");
    }
}
