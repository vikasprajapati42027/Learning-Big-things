import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.*;

@RestController
public class RetryDemo {
    @GetMapping("/retry")
    @Retry(name = "backendProcess", fallbackMethod = "failed")
    public String tryAgain() { 
        System.out.println("Attempting request...");
        throw new RuntimeException("Network Glitch"); 
    }
    public String failed(Exception e) { return "All retries failed after exponential backoff."; }
}
