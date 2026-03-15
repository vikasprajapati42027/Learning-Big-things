/**
 * Interviewer: Explain Service_Discovery Concept 6.
 * Candidate: Professional detailed answer regarding Service_Discovery 6.
 * 
 * Key Highlights: Eureka, Zookeeper, Config Server
 */
import java.util.List;
import java.util.Random;

public class Q6_Service_Discovery {
    public void demo() {
        List<String> instances = List.of("10.0.0.1:8080", "10.0.0.2:8080");
        String chosen = instances.get(new Random().nextInt(instances.size()));
        System.out.println("Load balancer picked: " + chosen);
    }
}
