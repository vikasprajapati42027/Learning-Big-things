/**
 * Interviewer: Explain Event_Driven Concept 6.
 * Candidate: Professional detailed answer regarding Event_Driven 6.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
import java.util.Comparator;
import java.util.List;

public class Q6_Event_Driven {
    public void demo() {
        List<String> events = List.of("3:Update", "1:Create", "2:Process");
        events.stream()
            .sorted(Comparator.comparingInt(e -> Integer.parseInt(e.split(":")[0])))
            .forEach(e -> System.out.println("Ordered event: " + e));
    }
}
