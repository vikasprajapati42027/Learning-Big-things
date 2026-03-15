/**
 * Interviewer: Explain Service_Discovery Concept 5.
 * Candidate: Professional detailed answer regarding Service_Discovery 5.
 * 
 * Key Highlights: Eureka, Zookeeper, Config Server
 */
import java.util.HashMap;
import java.util.Map;

public class Q5_Service_Discovery {
    public void demo() {
        Map<String, String> cache = new HashMap<>();
        cache.put("auth", "10.0.0.3:8082 (cached at 12:05)");
        System.out.println("Using cached discovery entry: " + cache.get("auth"));
    }
}
