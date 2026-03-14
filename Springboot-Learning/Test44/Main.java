package Test44;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Service Discovery (Eureka Server):
 * In microservices, instances are dynamic (IPs change). 
 * Eureka behaves like a "Phonebook" where services register themselves.
 */
@SpringBootApplication
// @EnableEurekaServer (Requires dependency)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
