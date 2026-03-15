/**
 * Interviewer: Explain Resilience Concept 8.
 * Candidate: Professional detailed answer regarding Resilience 8.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
public class Q8_Resilience {
    public void demo() {
        double latency = 120.5;
        double errorRate = 0.03;
        System.out.println("Metrics captured:");
        System.out.println("  Latency = " + latency + "ms");
        System.out.println("  Error rate = " + (errorRate * 100) + "%");
        if (latency > 100 || errorRate > 0.05) {
            System.out.println("Triggering alert channel for resilience teams.");
        } else {
            System.out.println("Metrics healthy.");
        }
    }
}
