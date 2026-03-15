/**
 * Interviewer: Explain Event_Driven Concept 1.
 * Candidate: Professional detailed answer regarding Event_Driven 1.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Q1_Event_Driven {
    public void demo() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> System.out.println("Event published: OrderCreated"), 0, TimeUnit.SECONDS);
        scheduler.schedule(() -> System.out.println("Subscriber received: OrderCreated"), 1, TimeUnit.SECONDS);
        scheduler.shutdown();
    }
}
