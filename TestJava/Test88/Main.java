package TestJava.Test88;

import java.util.concurrent.Phaser;

// A Phaser is a more flexible CyclicBarrier and CountDownLatch!
// - Threads can register/deregister dynamically at any time.
// - It operates in "Phases" (like levels in a game).
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Phaser (Advanced CyclicBarrier) ===\n");

        // The main thread registers itself to control when the phases start
        Phaser phaser = new Phaser(1); 

        System.out.println("Phase 0 (Setup) Starting...");

        // Start 3 workers
        for (int i = 1; i <= 3; i++) {
            phaser.register(); // Dynamically register a new party
            new Thread(new Worker(phaser, "Worker-" + i)).start();
        }

        // Main thread tells workers they can proceed to phase 1
        phaser.arriveAndAwaitAdvance(); 
        System.out.println("--- All workers passed Phase 0! ---\n");

        // Wait for workers to finish phase 1
        phaser.arriveAndAwaitAdvance();
        System.out.println("--- All workers passed Phase 1! ---\n");
        
        // Deregister the main thread so workers can finish without waiting for us
        phaser.arriveAndDeregister();
        System.out.println("Main thread is leaving the Phaser.\n");
        
        Thread.sleep(1000); // Give workers time to finish their print statements
    }
}

class Worker implements Runnable {
    private Phaser phaser;
    private String name;

    public Worker(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is doing setup work...");
        // Wait for everyone else to finish setup
        phaser.arriveAndAwaitAdvance();

        System.out.println(name + " is doing Phase 1 work...");
        phaser.arriveAndAwaitAdvance();
        
        System.out.println(name + " is doing Phase 2 work and then leaving!");
        // We are done. Deregister so we don't hold up others.
        phaser.arriveAndDeregister();
    }
}
