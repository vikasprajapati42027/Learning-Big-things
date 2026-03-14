package TestJava.Test29;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Type Casting (Implicit vs Explicit) ===");

        // --- 1. Implicit Casting (Widening) ---
        // Java does this automatically when converting a SMALLER type to a LARGER type.
        // Why? Because there is NO risk of losing data.
        System.out.println("\n--- 1. Implicit (Widening) Casting ---");
        int myInt = 100;
        double myDouble = myInt; // Automatic casting: int (32 bits) -> double (64 bits)
        
        System.out.println("Original int value: " + myInt);
        System.out.println("Widened double value: " + myDouble);

        // --- 2. Explicit Casting (Narrowing) ---
        // You MUST do this manually when converting a LARGER type to a SMALLER type.
        // Why? Because there IS a risk of losing data (e.g., decimals getting chopped off).
        System.out.println("\n--- 2. Explicit (Narrowing) Casting ---");
        double originalDouble = 9.78;
        
        // int myNewInt = originalDouble; // This would cause a compile error!
        int myNewInt = (int) originalDouble; // Manual casting: double -> int
        
        System.out.println("Original double value: " + originalDouble);
        System.out.println("Narrowed int value: " + myNewInt); // Notice the .78 was permanently lost!

        // --- 3. Object Casting (Polymorphism Context) ---
        System.out.println("\n--- 3. Object Casting ---");
        Object obj = "Hello Java"; // Upcasting (Implicit)
        
        // We know 'obj' contains a String, but the compiler only sees it as an 'Object'.
        // So we must Explicitly Cast (Downcast) it back to a String to use String methods.
        String str = (String) obj; 
        System.out.println("Downcasted String length: " + str.length());
    }
}
