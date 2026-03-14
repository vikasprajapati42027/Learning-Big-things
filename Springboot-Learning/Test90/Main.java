package Test90;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DDD (Domain-Driven Design):
 * An approach to software development where the code 
 * matches the business domain.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Core DDD Concepts:
 * 1. Entity: Has a unique ID (User).
 * 2. Value Object: No ID, defined by its attributes (Address).
 * 3. Aggregate Root: The entry point to a group of objects (Order).
 * 4. Bounded Context: A boundary where a model is valid (Sales vs Shipping).
 */
