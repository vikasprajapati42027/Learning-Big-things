/**
 * Interviewer: Explain Event_Driven Concept 2.
 * Candidate: Professional detailed answer regarding Event_Driven 2.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
import java.util.List;

public class Q2_Event_Driven {
    public void demo() {
        List<String> events = List.of("order.created", "inventory.updated", "order.shipped");
        events.stream()
            .filter(e -> e.startsWith("order."))
            .forEach(e -> System.out.println("Filtered order event: " + e));
    }
}
