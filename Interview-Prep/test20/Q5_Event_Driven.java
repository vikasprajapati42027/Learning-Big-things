/**
 * Interviewer: Explain Event_Driven Concept 5.
 * Candidate: Professional detailed answer regarding Event_Driven 5.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q5_Event_Driven {
    public void demo() {
        List<String> stream = List.of("evt1", "evt2", "evt1", "evt3");
        Set<String> seen = new HashSet<>();
        stream.forEach(evt -> {
            if (seen.add(evt)) {
                System.out.println("Processing unique event: " + evt);
            } else {
                System.out.println("Discarding duplicate: " + evt);
            }
        });
    }
}
