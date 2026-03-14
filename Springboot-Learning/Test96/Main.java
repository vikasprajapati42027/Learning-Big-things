package Test96;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * OAuth2 Resource Server:
 * An application that hosts the "Resources" (the data) 
 * and requires a valid JWT to access it.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Flow:
 * 1. Mobile App sends GET /photos with "Authorization: Bearer <JWT>".
 * 2. Resource Server validates the JWT signature and expiration.
 * 3. If valid, returns the data.
 */
