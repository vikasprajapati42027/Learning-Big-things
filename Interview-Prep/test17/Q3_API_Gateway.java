/**
 * Interviewer: Explain API_Gateway Concept 3.
 * Candidate: Professional detailed answer regarding API_Gateway 3.
 * 
 * Key Highlights: Routing, Authentication, Rate Limiting
 */
public class Q3_API_Gateway {
    public void demo() {
        int limit = 2;
        int requestCount = 3;
        for (int i = 1; i <= requestCount; i++) {
            if (i > limit) {
                System.out.println("Rate limit reached on request " + i + "; rejecting.");
            } else {
                System.out.println("Request " + i + " processed.");
            }
        }
    }
}
