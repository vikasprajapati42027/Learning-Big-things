package Test92;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clean Architecture (Robert C. Martin):
 * Similar to Hexagonal, but with a stricter focus on 
 * Dependency Rule: Dependencies point INWARD.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Layers (Inner to Outer):
 * 1. Entities: Enterprise business rules.
 * 2. Use Cases: Application business rules.
 * 3. Interface Adapters: Controllers, Gateways, Presenters.
 * 4. Frameworks & Drivers: The Database, Web server, etc.
 */
