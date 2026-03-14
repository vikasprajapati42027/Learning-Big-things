package Test48;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Distributed Tracing (Micrometer & Zipkin):
 * Track a request across multiple microservices. 
 * A single 'Trace ID' is passed from service to service.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
