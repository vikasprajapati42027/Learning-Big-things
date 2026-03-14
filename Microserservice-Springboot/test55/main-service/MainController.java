import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
    private final RestTemplate rest = new RestTemplate();

    @GetMapping("/get-data")
    @CircuitBreaker(name = "mainProvider", fallbackMethod = "callBackupService")
    public String getData() {
        return rest.getForObject("http://main-api/data", String.class);
    }

    public String callBackupService(Exception e) {
        System.out.println("Main Service Failed! Calling Backup Service...");
        return rest.getForObject("http://backup-api/data", String.class);
    }
}
