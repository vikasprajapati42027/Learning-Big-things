package test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Our very first Microservice: The Order Service.
 * It only focuses on one domain: Orders.
 */
@SpringBootApplication
@RestController
public class OrderServiceApplication {

    public static void main(String[] args) {
        System.out.println("Order Microservice is starting on port 8080...");
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @GetMapping("/orders")
    public List<String> getAllOrders() {
        return List.of("Smartphone", "Wireless Headphones", "Laptop Charger");
    }
}
