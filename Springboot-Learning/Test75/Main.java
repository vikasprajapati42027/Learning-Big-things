package Test75;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Statemachine:
 * A framework for using state machine concepts 
 * with a Spring application.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Use Case: Order Management System.
 * States: NEW -> PAID -> SHIPPED -> DELIVERED.
 * Events: PAY, SHIP, DELIVER.
 */
