package TestJava.Test33;

public class Main {
    
    // 1. FINAL variable: A constant. The value CANNOT be changed once assigned.
    final int MAX_SPEED = 120;
    
    // 2. FINAL class: Cannot be extended (inherited).
    final class SecureSystem {
        // 3. FINAL method: Cannot be overridden by child classes.
        final void authenticate() {
            System.out.println("Authentication logic that nobody can mess with.");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Final, Finally, Finalize ===");
        
        // --- Finally Block ---
        // Used in Try-Catch. ALWAYS executes regardless of whether an exception occurs. 
        // Crucial for cleaning up resources (like closing files or database connections).
        System.out.println("\n--- Finally ---");
        try {
            int result = 10 / 0; // This throws ArithmeticException
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            System.out.println("The FINALLY block executes no matter what!");
        }
        
        // --- Finalize Method ---
        // A method called by the Garbage Collector before an object is destroyed.
        // NOTE: It is deprecated in modern Java! Do not use it for resource cleanup.
        System.out.println("\n--- Finalize ---");
        System.out.println("The finalize() method is deprecated and should be avoided in modern Java code.");
    }
}
