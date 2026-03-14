package TestJava.Test115;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Modern Math Utility Methods ===\n");

        // --- Math Exact Methods (Java 8+) ---
        System.out.println("--- 1. Exact Methods (Overflow Prevention) ---");
        int maxInt = Integer.MAX_VALUE; // 2147483647
        
        // Standard addition silently overflows into negative numbers!
        System.out.println("Standard Addition      : " + maxInt + " + 1 = " + (maxInt + 1)); 
        
        try {
            // Math.addExact throws an Exception instead of silently corrupting data!
            System.out.print("Math.addExact()        : ");
            Math.addExact(maxInt, 1);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException Caught! " + e.getMessage());
        }

        // --- Math.clamp (Java 21+) ---
        System.out.println("\n--- 2. Math.clamp (Concept) ---");
        int valueToClamp = 150;
        int minAllowed = 0;
        int maxAllowed = 100;

        // In Java 17, we clamp values like this:
        int clampedJava17 = Math.max(minAllowed, Math.min(valueToClamp, maxAllowed));
        System.out.println("Java 17 Manual Clamp: Extracted " + valueToClamp + " -> Clamped to: " + clampedJava17);
        
        System.out.println("Java 21+ Native API : int clamped = Math.clamp(valueToClamp, minAllowed, maxAllowed);");
    }
}
