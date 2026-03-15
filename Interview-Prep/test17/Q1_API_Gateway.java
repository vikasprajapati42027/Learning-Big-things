/**
 * Interviewer: Explain API_Gateway Concept 1.
 * Candidate: Professional detailed answer regarding API_Gateway 1.
 * 
 * Key Highlights: Routing, Authentication, Rate Limiting
 */
import java.util.Map;

public class Q1_API_Gateway {
    public void demo() {
        Map<String, String> routeTable = Map.of(
            "/payments", "PaymentService",
            "/orders", "OrderService"
        );
        System.out.println("Route table configured:");
        routeTable.forEach((path, service) -> System.out.println(path + " -> " + service));
        String path = "/orders";
        System.out.println("Routing '" + path + "' to " + routeTable.get(path));
    }
}
