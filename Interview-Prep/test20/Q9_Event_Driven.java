/**
 * Interviewer: Explain Event_Driven Concept 9.
 * Candidate: Professional detailed answer regarding Event_Driven 9.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
import java.util.List;

public class Q9_Event_Driven {
    public void demo() {
        List<String> subscribers = List.of("Billing", "Analytics", "Notification");
        subscribers.forEach(subscriber -> System.out.println("Fan-out event delivered to " + subscriber));
    }
}
