/**
 * INTERVIEWER: Let's discuss Advanced Topic in Module 20.
 * 
 * CANDIDATE: Advanced Topic in Module 20 is a critical aspect of modern Java engineering. 
 * I have implemented several systems leveraging this to achieve high performance.
 *
 * PROPER EXPLANATION:
 * 1. Introduction to Advanced Topic in Module 20 and its architectural impact.
 * 2. Implementation details in a production environment.
 * 3. Handling concurrency and edge cases in Advanced Topic in Module 20.
 */
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class Event {
    final String type;
    final String payload;

    Event(String type, String payload) {
        this.type = type;
        this.payload = payload;
    }
}

interface EventHandler {
    void handle(Event event);
}

class EventBus {
    private final Map<String, List<EventHandler>> subscribers = new HashMap<>();

    void subscribe(String eventType, EventHandler handler) {
        subscribers.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>()).add(handler);
    }

    void publish(Event event) {
        List<EventHandler> handlers = subscribers.getOrDefault(event.type, Collections.emptyList());
        handlers.forEach(handler -> handler.handle(event));
    }
}

public class Q1_Main {
    public static void main(String[] args) {
        System.out.println("--- Interview Prep Masterclass: Advanced Topic in Module 20 ---");
        System.out.println("Executing Scenario for Module 20...");
        runScenario();
    }

    public static void runScenario() {
        EventBus bus = new EventBus();
        bus.subscribe("payment", event -> System.out.println("Payment listener got: " + event.payload));
        bus.subscribe("inventory", event -> System.out.println("Inventory listener processed: " + event.payload));

        List<Event> events = List.of(
            new Event("payment", "Order 1001 paid"),
            new Event("inventory", "Order 1001 reserved"),
            new Event("shipping", "Order 1001 ready")
        );
        events.forEach(bus::publish);

        System.out.println("Module 20 event-driven narrative executed with senior-level precision.");
    }
}
