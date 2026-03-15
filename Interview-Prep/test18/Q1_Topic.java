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
    static class WorkUnit implements Runnable {
        private final String action;

        WorkUnit(String action) {
            this.action = action;
        }

        @Override
        public void run() {
            System.out.println("Executing work unit: " + action);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Mastering Advanced Java Engineering: Step 1 ---");
        executeCoreLogic();
    }

    private static void executeCoreLogic() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(2);
        executor.submit(() -> { new WorkUnit("Scale monitoring").run(); latch.countDown(); });
        executor.submit(() -> { new WorkUnit("Failure recovery").run(); latch.countDown(); });
        latch.await();
        executor.shutdown();
        System.out.println("Logic for Advanced Java Engineering (Scenario 1) executed successfully.");
    }
}
