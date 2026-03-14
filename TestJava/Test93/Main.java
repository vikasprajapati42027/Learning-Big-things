package TestJava.Test93;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ThreadGroup & UncaughtExceptionHandler ===\n");

        // 1. ThreadGroup
        // Used to group threads together so you can interrupt or manage them as a single unit.
        // (Note: ThreadPools like ExecutorService largely replaced direct ThreadGroup usage in modern Java, but it's good to know)
        ThreadGroup myTeam = new ThreadGroup("Backend-Team");

        Thread t1 = new Thread(myTeam, () -> {
            try {
                System.out.println("Worker 1 running in group: " + Thread.currentThread().getThreadGroup().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        });
        
        Thread t2 = new Thread(myTeam, () -> {
            System.out.println("Worker 2 is about to crash!");
            throw new RuntimeException("Database connection lost!");
        });

        // 2. UncaughtExceptionHandler
        // If a thread throws a RuntimeException and dies unexpectedly, how do you log it?
        // You set an exception handler!
        t2.setUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println("CRITICAL ALERT: Thread '" + thread.getName() + "' died!");
            System.err.println("Cause: " + throwable.getMessage());
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join(); // Won't block long because t2 crashes instantly
        
        System.out.println("\nMain thread completes cleanly despite thread crash.");
    }
}
