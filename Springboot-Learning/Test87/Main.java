package Test87;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Saga Pattern:
 * Managing data consistency across microservices 
 * in distributed transactions.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * The 2 Types:
 * 1. Choreography: Each service publishes events, others listen.
 * 2. Orchestration: A central "Manager" tells everyone what to do.
 */
