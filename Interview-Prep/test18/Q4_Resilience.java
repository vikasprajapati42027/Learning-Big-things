/**
 * Interviewer: Explain Resilience Concept 4.
 * Candidate: Professional detailed answer regarding Resilience 4.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
public class Q4_Resilience {
    public void demo() {
        try {
            callPrimary();
        } catch (IllegalStateException ex) {
            System.out.println("Primary failed: " + ex.getMessage());
            System.out.println("Executing fallback logic.");
        }
    }

    private void callPrimary() {
        throw new IllegalStateException("Primary service unavailable");
    }
}
