/**
 * Interviewer: Explain Resilience Concept 9.
 * Candidate: Professional detailed answer regarding Resilience 9.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
public class Q9_Resilience {
    public void demo() {
        System.out.println("Sending request to two replicas for hedging:");
        System.out.println("  Replica A responded in 30ms");
        System.out.println("  Replica B responded in 45ms");
        System.out.println("Using faster Replica A output.");
    }
}
