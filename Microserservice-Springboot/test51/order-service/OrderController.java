import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final RestTemplate rest = new RestTemplate();

    @GetMapping("/create")
    @CircuitBreaker(name = "inventoryService", fallbackMethod = "inventoryFallback")
    public String createOrder() {
        // Calling inventory service which might be DOWN
        return rest.getForObject("http://localhost:8081/inventory/check", String.class);
    }

    // Fallback: This is called when inventory service fails or circuit is OPEN
    public String inventoryFallback(Exception e) {
        return "FALLBACK: Inventory Service is currently unavailable. Please try again later.";
    }
}
