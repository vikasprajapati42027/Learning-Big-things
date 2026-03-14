package TestJava.Test28;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Math Class Utilities Tutorial ===");

        // The Math class provides basic numeric operations.
        // All its methods are STATIC, so we don't need to create a Math object.

        // 1. Min and Max
        System.out.println("\n--- 1. Min & Max ---");
        System.out.println("Max of 10 and 20: " + Math.max(10, 20));
        System.out.println("Min of 10 and 20: " + Math.min(10, 20));

        // 2. Rounding
        System.out.println("\n--- 2. Rounding ---");
        System.out.println("Round 4.6 (Nearest integer): " + Math.round(4.6));
        System.out.println("Round 4.4 (Nearest integer): " + Math.round(4.4));
        System.out.println("Ceil 4.1 (Always round UP): " + Math.ceil(4.1));
        System.out.println("Floor 4.9 (Always round DOWN): " + Math.floor(4.9));

        // 3. Powers and Roots
        System.out.println("\n--- 3. Powers & Roots ---");
        System.out.println("Square root of 64: " + Math.sqrt(64));
        System.out.println("2 to the power of 3: " + Math.pow(2, 3));

        // 4. Random Numbers
        System.out.println("\n--- 4. Random Numbers ---");
        // Math.random() returns a double between 0.0 (inclusive) and 1.0 (exclusive)
        double rawRandom = Math.random();
        System.out.println("Raw random (0.0 to 1.0): " + rawRandom);
        
        // Trick to get a random integer from 1 to 10:
        int random1to10 = (int)(Math.random() * 10) + 1;
        System.out.println("Random integer (1 to 10): " + random1to10);
    }
}
