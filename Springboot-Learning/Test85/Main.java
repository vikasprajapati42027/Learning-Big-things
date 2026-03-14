package Test85;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Event Sourcing:
 * Storing every "Change" as an event, 
 * rather than just storing the "Current State".
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example: Bank Account
 * Standard: Balance = 500.
 * Event Sourcing: 
 *   - Created (+0)
 *   - Deposited (+1000)
 *   - Withdrawn (-500)
 * Current state is calculated by replaying events!
 */
