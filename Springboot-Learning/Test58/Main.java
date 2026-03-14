package Test58;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot with Groovy:
 * A dynamic language for the JVM.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * (Simulated Groovy Code)
 * 
 * @RestController
 * class HelloController {
 *     @GetMapping("/groovy")
 *     String hello() { "Hello from Groovy!" }
 * }
 */
