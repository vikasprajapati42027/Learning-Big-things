package Test47;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Resilience4j (Circuit Breaker):
 * Fault tolerance for microservices. 
 * If a dependency is down, the Circuit Breaker "opens" 
 * and prevents further calls for a while.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Example usage:
 * 
 * @CircuitBreaker(name = "paymentService", fallbackMethod = "defaultPayment")
 * public String doPayment() {
 *     return restTemplate.getForObject("http://payment/pay", String.class);
 * }
 * 
 * public String defaultPayment(Exception e) {
 *     return "Payment service is currently unavailable. Please try later.";
 * }
 */
