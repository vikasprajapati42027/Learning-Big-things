import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class LogServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(LogServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogServiceApplication.class, args);
    }

    @GetMapping("/log")
    public String generateLog() {
        logger.info("INFO: Business transaction started");
        logger.error("ERROR: Simulated system failure");
        return "Logs generated!";
    }
}
