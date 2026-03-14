package Test60;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Observability:
 * Monitoring, Logging, and Tracing working together 
 * to show you exactly what's happening.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Concepts:
 * 1. Metrics (Micrometer): Numerical data (CPU, Memory).
 * 2. Logging: Textual events.
 * 3. Tracing: Flow of a single request.
 */
