/**
 * Interviewer: Explain Service_Discovery Concept 1.
 * Candidate: Professional detailed answer regarding Service_Discovery 1.
 * 
 * Key Highlights: Eureka, Zookeeper, Config Server
 */
import java.util.*;

public class Q1_Service_Discovery {
    public void demo() {
        Map<String, String> registry = new HashMap<>();
        registry.put("order", "10.0.0.1:8080");
        registry.put("payment", "10.0.0.2:8080");
        System.out.println("Service registry snapshot: " + registry);
    }
}
