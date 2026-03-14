import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.web.bind.annotation.*;

@RestController
public class BulkheadDemo {
    @GetMapping("/heavy")
    @Bulkhead(name = "heavyWorkPool", fallbackMethod = "busy")
    public String doWork() { return "Working..."; }
    
    public String busy(Exception e) { return "Pool Full! Please wait."; }
}
