/**
 * Interviewer: Explain Resilience Concept 2.
 * Candidate: Professional detailed answer regarding Resilience 2.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
import java.util.concurrent.*;

public class Q2_Resilience {
    public void demo() throws InterruptedException {
        ExecutorService bulkhead = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            bulkhead.submit(() -> {
                try {
                    System.out.println("Processing task " + taskId + " within bulkhead.");
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        bulkhead.shutdown();
        System.out.println("Bulkhead contained tasks to avoid resource exhaustion.");
    }
}
