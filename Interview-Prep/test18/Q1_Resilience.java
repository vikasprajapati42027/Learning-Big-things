/**
 * Interviewer: Explain Resilience Concept 1.
 * Candidate: Professional detailed answer regarding Resilience 1.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
public class Q1_Resilience {
    static class CircuitBreaker {
        private int failureCount = 0;
        private final int threshold = 2;
        boolean isOpen() {
            return failureCount >= threshold;
        }

        void recordFailure() {
            failureCount++;
        }

        void recordSuccess() {
            failureCount = 0;
        }
    }

    public void demo() {
        CircuitBreaker breaker = new CircuitBreaker();
        for (int i = 0; i < 4; i++) {
            if (breaker.isOpen()) {
                System.out.println("Breaker open; returning fallback.");
                continue;
            }
            if (i % 2 == 0) {
                System.out.println("Call failed.");
                breaker.recordFailure();
            } else {
                System.out.println("Call succeeded.");
                breaker.recordSuccess();
            }
        }
    }
}
