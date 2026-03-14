import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;

@RestController
public class StateDemoController {

    @GetMapping("/test")
    @CircuitBreaker(name = "stateService", fallbackMethod = "handle")
    public String riskyOperation() {
        throw new RuntimeException("Forced Failure");
    }

    public String handle(Throwable t) {
        return "Circuit State: Potential OPEN transition triggered!";
    }
}
