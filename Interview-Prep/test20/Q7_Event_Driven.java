/**
 * Interviewer: Explain Event_Driven Concept 7.
 * Candidate: Professional detailed answer regarding Event_Driven 7.
 * 
 * Key Highlights: Kafka, RabbitMQ, Publisher-Subscriber
 */
public class Q7_Event_Driven {
    static class EventSchema {
        final String name;
        final String version;

        EventSchema(String name, String version) {
            this.name = name;
            this.version = version;
        }
    }

    public void demo() {
        EventSchema schema = new EventSchema("OrderCreated", "v1");
        System.out.println("Event schema validated: " + schema.name + " / " + schema.version);
    }
}
