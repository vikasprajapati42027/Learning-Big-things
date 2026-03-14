package Test81;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Cloud Stream:
 * A framework for building highly scalable event-driven 
 * microservices connected with shared messaging systems.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Modern Functional Approach:
 * 
 * @Bean
 * public Function<String, String> uppercase() {
 *     return String::toUpperCase;
 * }
 */
