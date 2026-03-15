/**
 * Interviewer: Explain Resilience Concept 5.
 * Candidate: Professional detailed answer regarding Resilience 5.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
public class Q5_Resilience {
    public void demo() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(150);
            System.out.println("Service responded within time.");
        } catch (InterruptedException ignored) {
        }
        long duration = System.currentTimeMillis() - start;
        if (duration > 100) {
            System.out.println("Timeout occurred (duration: " + duration + "ms); canceling request.");
        }
    }
}
