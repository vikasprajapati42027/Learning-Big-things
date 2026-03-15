/**
 * Interviewer: Explain Resilience Concept 6.
 * Candidate: Professional detailed answer regarding Resilience 6.
 * 
 * Key Highlights: Circuit Breaker, Bulkhead, Retry, Fallback
 */
public class Q6_Resilience {
    public void demo() {
        int currentLoad = 85;
        int maxLoad = 80;
        if (currentLoad > maxLoad) {
            System.out.println("Load too high (" + currentLoad + "%). Shedding low-priority requests.");
        } else {
            System.out.println("Load acceptable; processing all requests.");
        }
    }
}
