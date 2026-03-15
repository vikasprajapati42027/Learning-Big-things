/**
 * Interviewer: Explain Event_Driven Concept 4.
 * Candidate: Professional detailed answer regarding Event_Driven 4.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class Q4_Event_Driven {
    public void demo() {
        Queue<String> backlog = new ArrayDeque<>();
        backlog.add("event-A");
        backlog.add("event-B");
        while (!backlog.isEmpty()) {
            String event = backlog.poll();
            System.out.println("Processing backlog event: " + event);
        }
    }
}
