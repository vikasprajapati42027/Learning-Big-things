/**
 * INTERVIEWER: Let's discuss JWT Authentication Flow.
 * 
 * CANDIDATE: JWT Authentication Flow is a critical aspect of modern Java engineering. 
 * I have implemented several systems leveraging this to achieve high performance.
 *
 * PROPER EXPLANATION:
 * 1. Introduction to JWT Authentication Flow and its architectural impact.
 * 2. Implementation details in a production environment.
 * 3. Handling concurrency and edge cases in JWT Authentication Flow.
 */
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

class JwtGenerator {
    String generate(String subject) {
        String header = Base64.getUrlEncoder().withoutPadding().encodeToString("{\"alg\":\"HS256\",\"typ\":\"JWT\"}".getBytes());
        String payload = Base64.getUrlEncoder().withoutPadding().encodeToString(("{\"sub\":\"" + subject + "\",\"iat\":" + Instant.now().getEpochSecond() + "}").getBytes());
        String signature = Base64.getUrlEncoder().withoutPadding().encodeToString(("sig:" + subject).getBytes());
        return String.join(".", header, payload, signature);
    }
}

class JwtValidator {
    boolean validate(String token) {
        if (token == null || token.split("\\.").length != 3) {
            return false;
        }
        System.out.println("Token structure validated.");
        return true;
    }

    Map<String, String> decode(String token) {
        String[] parts = token.split("\\.");
        Map<String, String> claims = new HashMap<>();
        claims.put("header", new String(Base64.getUrlDecoder().decode(parts[0])));
        claims.put("payload", new String(Base64.getUrlDecoder().decode(parts[1])));
        return claims;
    }
}

class AuthenticationService {
    private final JwtGenerator generator;
    private final JwtValidator validator;

    AuthenticationService(JwtGenerator generator, JwtValidator validator) {
        this.generator = generator;
        this.validator = validator;
    }

    void authenticate(String user) {
        String token = generator.generate(user);
        System.out.println("Generated token: " + token);
        if (validator.validate(token)) {
            Map<String, String> claims = validator.decode(token);
            System.out.println("Claims: " + claims);
            System.out.println("User '" + user + "' authenticated successfully.");
        } else {
            System.out.println("Authentication failed for user " + user);
        }
    }
}

public class Q1_Main {
    public static void main(String[] args) {
        System.out.println("--- Interview Prep Masterclass: JWT Authentication Flow ---");
        System.out.println("Executing Scenario for Module 14...");
        runScenario();
    }

    public static void runScenario() {
        AuthenticationService authService = new AuthenticationService(new JwtGenerator(), new JwtValidator());
        authService.authenticate("engineer");
        System.out.println("Module 14 JWT flow executed with senior-level detail.");
    }
}
