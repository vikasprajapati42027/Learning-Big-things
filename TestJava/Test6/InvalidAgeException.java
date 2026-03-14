package TestJava.Test6;

/**
 * Custom Exception demonstrating how to create your own error types.
 * Extending RuntimeException makes it an Unchecked Exception.
 * Extending Exception makes it a Checked Exception (requires throws/catch).
 */
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
