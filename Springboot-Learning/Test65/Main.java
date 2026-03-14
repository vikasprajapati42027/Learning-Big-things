package Test65;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Advanced RabbitMQ:
 * Understanding Routing Keys, Exchanges, and Queues.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Types of Exchanges:
 * 1. Direct: Message goes to queue matching the routing key.
 * 2. Topic: Matches routing key with patterns (e.g., auth.*).
 * 3. Fanout: Broadacasts to ALL queues bound to it.
 * 4. Headers: Uses message headers for routing.
 */
