/**
 * Interviewer: Explain Service_Discovery Concept 4.
 * Candidate: Professional detailed answer regarding Service_Discovery 4.
 * 
 * Key Highlights: Eureka, Zookeeper, Config Server
 */
import java.util.*;

public class Q4_Service_Discovery {
    public void demo() {
        Properties config = new Properties();
        config.setProperty("payment.timeout", "2s");
        config.setProperty("order.retry", "3");
        System.out.println("Config server delivered: " + config);
    }
}
