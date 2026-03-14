package Test45;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Cloud Gateway:
 * The single entry point for all client requests.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Roles of a Gateway:
 * 1. Routing: Sending requests to correct services.
 * 2. Security: Authentication (JWT validation) at the door.
 * 3. Rate Limiting: Preventing DDoS or API abuse.
 * 4. Monitoring: Logging all incoming traffic.
 */
