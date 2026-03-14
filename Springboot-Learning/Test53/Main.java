package Test53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Integration:
 * Connecting different systems using design patterns like 
 * Message Channels and Service Activators.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Concept:
 * 1. Message: The data package.
 * 2. Message Channel: The pipe where messages travel.
 * 3. Transformer: Changes the data in flight.
 * 4. Filter: Decides if a message should continue.
 */
