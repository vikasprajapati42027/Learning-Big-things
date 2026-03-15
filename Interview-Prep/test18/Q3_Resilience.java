/**
 * Interviewer: Explain Resilience Concept 3.
 * Candidate: Professional detailed answer regarding Resilience 3.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
public class Q3_Resilience {
    interface RemoteCall {
        boolean execute();
    }

    public void demo() {
        RemoteCall call = () -> Math.random() > 0.5;
        int attempts = 0;
        while (attempts < 3) {
            attempts++;
            if (call.execute()) {
                System.out.println("Call succeeded on attempt " + attempts);
                return;
            }
            System.out.println("Retrying attempt " + attempts);
        }
        System.out.println("All retries exhausted; marking failure.");
    }
}
