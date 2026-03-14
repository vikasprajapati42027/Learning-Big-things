package Test91;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hexagonal Architecture (Ports and Adapters):
 * Keeping your business logic independent of external tools 
 * (DB, UI, Frameworks).
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Structure:
 * 1. Domain (The Core): Pure Java logic. No Spring annotations!
 * 2. Ports: Interfaces that the core uses (e.g., UserRepositoryPort).
 * 3. Adapters: Implementations of ports (e.g., JpaUserAdapter).
 */
