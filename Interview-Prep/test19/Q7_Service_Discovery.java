/**
 * Interviewer: Explain Service_Discovery Concept 7.
 * Candidate: Professional detailed answer regarding Service_Discovery 7.
 * 
 * Key Highlights: Eureka, Zookeeper, Config Server
 */
import java.util.HashSet;
import java.util.Set;

public class Q7_Service_Discovery {
    public void demo() {
        Set<String> services = new HashSet<>();
        services.add("notifications");
        System.out.println("Registered services: " + services);
        services.remove("notifications");
        System.out.println("Deregistered notifications, current registry: " + services);
    }
}
