package Test57;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot with Kotlin:
 * Kotlin is a first-class citizen in the Spring world.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * (Simulated Kotlin Code)
 * 
 * @RestController
 * class HelloController {
 *     @GetMapping("/kotlin")
 *     fun hello() = "Hello from Kotlin!"
 * }
 */
