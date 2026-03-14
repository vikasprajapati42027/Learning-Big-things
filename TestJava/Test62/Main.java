package TestJava.Test62;

// Custom Unchecked Exception (Runtime)
class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Custom Exceptions vs Standard Exceptions ===\n");

        System.out.println("--- 1. Standard Exceptions ---");
        try {
            // Standard Java Exception used incorrectly:
            // Throwing generic IllegalArgumentException doesn't explain DOMAIN context well.
            throw new IllegalArgumentException("Password must be 8 chars long.");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Standard: " + e.getMessage());
        }

        System.out.println("\n--- 2. Custom Exceptions ---");
        try {
            // Custom Exception provides immediate BUSINESS context.
            // When debugging, seeing "InvalidPasswordException" is clearer than "IllegalArgumentException".
            registerUser("short");
        } catch (InvalidPasswordException e) {
            System.out.println("Caught Custom: " + e.getMessage());
        }
    }

    private static void registerUser(String password) {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password too short for security policies.");
        }
        System.out.println("User registered successfully!");
    }
}
