package Test79;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

/**
 * @RefreshScope:
 * Allows you to change @Value properties at runtime 
 * without restarting the application!
 */
@SpringBootApplication
@RestController
@RefreshScope
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Value("${message:Hello Default}")
    private String message;

    @GetMapping("/msg")
    public String getMessage() {
        return message;
    }
}
