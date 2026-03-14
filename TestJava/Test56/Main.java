package TestJava.Test56;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Bitwise Operators Tutorial ===\n");

        // These operators operate at the BINARY level (0s and 1s) of integers.
        // Let's use two small numbers for easy binary representation:
        int a = 5;  // Binary: 0101
        int b = 3;  // Binary: 0011

        System.out.println("a = 5 (0101)");
        System.out.println("b = 3 (0011)\n");

        // 1. Bitwise AND (&): 1 if BOTH bits are 1
        System.out.println("--- 1. AND (&) ---");
        // 0101
        // 0011
        // ----
        // 0001 (Which is 1 in decimal)
        System.out.println("a & b = " + (a & b)); 

        // 2. Bitwise OR (|): 1 if AT LEAST ONE bit is 1
        System.out.println("\n--- 2. OR (|) ---");
        // 0101
        // 0011
        // ----
        // 0111 (Which is 7 in decimal)
        System.out.println("a | b = " + (a | b));

        // 3. Bitwise XOR (^): 1 if bits are DIFFERENT
        System.out.println("\n--- 3. XOR (^) ---");
        // 0101
        // 0011
        // ----
        // 0110 (Which is 6 in decimal)
        System.out.println("a ^ b = " + (a ^ b));

        // 4. Bitwise NOT (~): Inverts all bits (0 becomes 1, 1 becomes 0)
        System.out.println("\n--- 4. NOT (~) ---");
        // ~5 (-6 in 2's complement representation)
        System.out.println("~a = " + (~a));

        // 5. Shift Operators (Moving bits left or right)
        System.out.println("\n--- 5. Shift Operators ---");
        // Left Shift (<<): Shifts bits left, fills with 0. Effectively multiplies by 2 for each step.
        // 5 (0000 0101) << 1 becomes 10 (0000 1010)
        System.out.println("a << 1 (Left shift by 1) = " + (a << 1)); 

        // Right Shift (>>): Shifts bits right. Effectively divides by 2 for each step.
        // 5 (0000 0101) >> 1 becomes 2 (0000 0010)
        System.out.println("a >> 1 (Right shift by 1) = " + (a >> 1));
    }
}
