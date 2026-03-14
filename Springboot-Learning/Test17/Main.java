package Test17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Security: Basic Auth (Default behavior).
 * Just by adding the security dependency, everything is protected.
 */
@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/secure")
    public String secureData() {
        return "You are seeing this because you are authenticated!";
    }
}
