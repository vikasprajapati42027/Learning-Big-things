package TestJava.Test7;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Multithreading Tutorial ===");
        System.out.println("Main thread started: " + Thread.currentThread().getName());

        // 1. Using a class that extends Thread
        WorkerThread worker1 = new WorkerThread("Worker-1");
        // IMPORTANT: Always call start(), NEVER run().
        // start() creates the new thread. run() just executes on the current thread!
        worker1.start(); 

        // 2. Using a class that implements Runnable
        TaskRunnable myRunnable = new TaskRunnable();
        // Since it's just a Runnable, we need to pass it to a real Thread object
        Thread runnableThread = new Thread(myRunnable, "Runnable-Thread-1");
        runnableThread.start();

        // 3. Using a Lambda Expression (Because Runnable is a Functional Interface!)
        Thread lambdaThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " (Lambda) is running!");
            try { Thread.sleep(200); } catch (Exception e) {}
            System.out.println(Thread.currentThread().getName() + " finished.");
        }, "Lambda-Thread");
        lambdaThread.start();

        // 4. Using join() to wait for threads to finish
        try {
            System.out.println("\nMain thread waiting for others to finish...");
            worker1.join(); // Main thread pauses here until worker1 dies
            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll worker threads completed. Main thread terminating.");
    }
}
