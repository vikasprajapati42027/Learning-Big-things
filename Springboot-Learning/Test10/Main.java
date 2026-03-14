package Test10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Test 10: Global Error Handling & Validation...");
        System.out.println("Endpoint: POST http://localhost:8080/users");
        SpringApplication.run(Main.class, args);
    }
}
