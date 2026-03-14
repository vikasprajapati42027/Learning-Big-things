package Test95;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * OAuth2 Login:
 * Allowing users to sign in with their existing Google, 
 * GitHub, or Facebook accounts.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Configuration in application.yml:
 * spring:
 *   security:
 *     oauth2:
 *       client:
 *         registration:
 *           google:
 *             client-id: YOUR_ID
 *             client-secret: YOUR_SECRET
 */
