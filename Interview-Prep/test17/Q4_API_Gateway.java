/**
 * Interviewer: Explain API_Gateway Concept 4.
 * Candidate: Professional detailed answer regarding API_Gateway 4.
 * 
 * Key Highlights: Routing, Authentication, Rate Limiting
 */
import java.util.HashMap;
import java.util.Map;

public class Q4_API_Gateway {
    public void demo() {
        Map<String, String> cache = new HashMap<>();
        cache.put("/status", "OK");
        System.out.println("Cache hit for /status -> " + cache.get("/status"));
        System.out.println("Forwarding /status response without hitting origin service.");
    }
}
