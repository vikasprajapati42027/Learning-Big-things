/**
 * Interviewer: Explain Microservices_Architecture Concept 1.
 * Candidate: Professional detailed answer regarding Microservices_Architecture 1.
 * 
 * Key Highlights: Independence, Scaling, Polyglot, Small Services
 */
import java.util.*;

class ServiceDefinition {
    private final String name;
    private final boolean stateless;
    private final String language;

    ServiceDefinition(String name, boolean stateless, String language) {
        this.name = name;
        this.stateless = stateless;
        this.language = language;
    }

    void describe() {
        System.out.println(name + " -> stateless:" + stateless + " language:" + language);
    }
}

public class Q1_Microservices_Architecture {
    public void demo() {
        System.out.println("Concept 1: Independence of services.");
        ServiceDefinition service = new ServiceDefinition("AuthService", true, "Java");
        service.describe();
    }
}
