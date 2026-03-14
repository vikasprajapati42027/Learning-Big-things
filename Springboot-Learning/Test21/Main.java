package Test21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Actuator:
 * It brings production-ready features to your app.
 * It provides several built-in endpoints to monitor and interact 
 * with your application.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Common Actuator Endpoints:
 * /actuator/health  - Shows basic health info.
 * /actuator/info    - Displays arbitrary application info.
 * /actuator/metrics - Shows performance metrics (CPU, Memory).
 * /actuator/env     - Shows the current environment properties.
 */
