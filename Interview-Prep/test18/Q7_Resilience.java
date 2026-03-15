/**
 * Interviewer: Explain Resilience Concept 7.
 * Candidate: Professional detailed answer regarding Resilience 7.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
import java.util.concurrent.*;

public class Q7_Resilience {
    public void demo() throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println("Executing guarded task.");
            } catch (InterruptedException ignored) {
            } finally {
                semaphore.release();
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            executor.submit(task);
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("Semaphore enforced bulkhead to limit concurrency.");
    }
}
