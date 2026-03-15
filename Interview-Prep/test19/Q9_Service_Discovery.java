/**
 * Interviewer: Explain Service_Discovery Concept 9.
 * Candidate: Professional detailed answer regarding Service_Discovery 9.
 * 
 * Key Highlights: Eureka, Zookeeper, Config Server
 */
import java.util.List;

public class Q9_Service_Discovery {
    public void demo() {
        List<String> sources = List.of("primary", "secondary");
        for (String source : sources) {
            if ("primary".equals(source)) {
                System.out.println("Primary found unhealthy, switching to fallback.");
                continue;
            }
            System.out.println("Secondary handles request.");
            break;
        }
    }
}
