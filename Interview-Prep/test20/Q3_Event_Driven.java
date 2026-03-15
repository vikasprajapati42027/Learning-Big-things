/**
 * Interviewer: Explain Event_Driven Concept 3.
 * Candidate: Professional detailed answer regarding Event_Driven 3.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
public class Q3_Event_Driven {
    public void demo() {
        boolean ack = false;
        int attempts = 0;
        while (!ack && attempts < 3) {
            attempts++;
            System.out.println("Publishing event attempt " + attempts);
            ack = simulateAck(attempts);
        }
        System.out.println(ack ? "Event acknowledged." : "Giving up after retries.");
    }

    private boolean simulateAck(int attempt) {
        return attempt > 1;
    }
}
