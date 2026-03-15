/**
 * Interviewer: Explain API_Gateway Concept 6.
 * Candidate: Professional detailed answer regarding API_Gateway 6.
 * 
 * Key Highlights: Routing, Authentication, Rate Limiting
 */
import java.util.List;

public class Q6_API_Gateway {
    public void demo() {
        List<String> downstreamResponses = List.of("payment-ok", "notification-ok");
        System.out.println("Aggregating downstream responses:");
        downstreamResponses.forEach(response -> System.out.println("  " + response));
        System.out.println("Returning merged response to client.");
    }
}
