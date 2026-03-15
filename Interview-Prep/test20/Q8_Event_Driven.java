/**
 * Interviewer: Explain Event_Driven Concept 8.
 * Candidate: Professional detailed answer regarding Event_Driven 8.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
import java.util.LinkedList;
import java.util.Queue;

public class Q8_Event_Driven {
    public void demo() {
        Queue<String> dlq = new LinkedList<>();
        try {
            throw new RuntimeException("Processing failed");
        } catch (RuntimeException ex) {
            dlq.add("Event moved to DLQ: " + ex.getMessage());
        }
        dlq.forEach(System.out::println);
    }
}
