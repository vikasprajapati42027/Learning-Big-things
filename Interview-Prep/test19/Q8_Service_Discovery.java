/**
 * Interviewer: Explain Service_Discovery Concept 8.
 * Candidate: Professional detailed answer regarding Service_Discovery 8.
 * 
 * Key Highlights: Eureka, Zookeeper, Config Server
 */
import java.util.Map;

public class Q8_Service_Discovery {
    public void demo() {
        Map<String, String> metadata = Map.of("version", "1.0", "region", "us-east");
        System.out.println("Service metadata matches client selector: " + metadata);
    }
}
