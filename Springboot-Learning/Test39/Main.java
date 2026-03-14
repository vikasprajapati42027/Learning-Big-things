package Test39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Multi-tenancy:
 * Serving multiple customers (tenants) from a single 
 * running instance of the app.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Strategies:
 * 1. Database per tenant (Highest isolation, high cost).
 * 2. Schema per tenant (Good isolation, medium cost).
 * 3. Table per tenant (Shared database/schema, discriminator column).
 */
