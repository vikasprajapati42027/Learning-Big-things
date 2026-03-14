package Test6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Test 6: REST Basics...");
        System.out.println("The server would normally start on http://localhost:8080");
        SpringApplication.run(Main.class, args);
    }
}
