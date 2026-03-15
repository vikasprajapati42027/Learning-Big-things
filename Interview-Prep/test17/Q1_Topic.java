/**
 * INTERVIEWER: Let's discuss Advanced Java Engineering - Scenario 1.
 * 
 * CANDIDATE: In this scenario, we focus on applying the core principles of Advanced Java Engineering 
 * to handle real-world challenges like scalability, maintainability, and concurrency.
 *
 * PROPER EXPLANATION:
 * 1. Deep dive into the architectural significance of Advanced Java Engineering.
 * 2. Key implementation patterns used in modern enterprise Java.
 * 3. Handling edge cases and ensuring thread-safety/data-integrity.
 */
import java.util.concurrent.*;

public class Q1_Scenario {
    static class Task implements Runnable {
        private final String name;

        Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Executing task: " + name);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Mastering Advanced Java Engineering: Step 1 ---");
        executeCoreLogic();
    }

    private static void executeCoreLogic() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);
        executor.submit(() -> {
            new Task("Scale analysis").run();
            latch.countDown();
        });
        executor.submit(() -> {
            new Task("Resilience plan").run();
            latch.countDown();
        });
        try {
            latch.await();
            System.out.println("Logic for Advanced Java Engineering (Scenario 1) executed successfully.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }
}
