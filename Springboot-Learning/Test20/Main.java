package Test20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * JWT (JSON Web Token) is used for Stateless Authentication.
 * Very popular for modern web apps and microservices.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * The JWT Flow:
 * 1. User sends Login (Username/Password).
 * 2. Server validates and generates a signed Token (JWT).
 * 3. Server sends JWT back to user.
 * 4. User sends JWT in the Header for all subsequent requests.
 *    (Authorization: Bearer <token>)
 */
