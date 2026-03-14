package TestJava.Test36;

class Printer {
    // --- 1. Method Overloading (Compile-Time Polymorphism) ---
    // Same method name, but DIFFERENT parameters (type or number).
    // Happens inside the SAME class.
    
    public void print(String text) {
        System.out.println("Printing Text: " + text);
    }
    
    public void print(int number) {
        System.out.println("Printing Number: " + number);
    }
    
    public void print(String text, int times) {
        System.out.println("Printing '" + text + "' exactly " + times + " times.");
    }
    
    // Virtual method to be overridden later
    public void paperType() {
        System.out.println("Standard A4 Paper");
    }
}

class PhotoPrinter extends Printer {
    // --- 2. Method Overriding (Run-Time Polymorphism) ---
    // EXACT SAME method signature (name and parameters).
    // Happens between a PARENT and a CHILD class. Takes priority over the parent!
    
    @Override
    public void paperType() {
        System.out.println("Glossy Photo Paper");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Overloading vs Overriding ===");
        
        Printer myPrinter = new Printer();
        System.out.println("\n--- Overloading (Same method, diff args) ---");
        myPrinter.print("Hello");
        myPrinter.print(404);
        myPrinter.print("Warning", 3);
        
        System.out.println("\n--- Overriding (Same method, changed parent behavior) ---");
        Printer basicPrinter = new Printer();
        basicPrinter.paperType(); // Prints: Standard A4 Paper
        
        Printer advancedPrinter = new PhotoPrinter();
        advancedPrinter.paperType(); // Prints: Glossy Photo Paper
    }
}
