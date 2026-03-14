package TestJava.Test39;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Wrapper Classes & Autoboxing ===");

        // Primitives: int, char, double, boolean
        // Wrappers: Integer, Character, Double, Boolean
        
        // Why Wrapper classes? 
        // 1. Collections (like ArrayList) CANNOT store primitives. They only store Objects.
        // 2. Wrappers provide thousands of utility methods (e.g., Integer.parseInt).

        System.out.println("\n--- 1. Autoboxing (Primitive -> Wrapper) ---");
        int primitiveInt = 42;
        
        // Old way (Java 4 or earlier): Integer wrappedInt = new Integer(primitiveInt);
        
        // Modern Java AUTOMATICALLY wraps the primitive in the Object. This is Autoboxing!
        Integer wrappedInt = primitiveInt; 
        System.out.println("Wrapped Integer object value: " + wrappedInt);

        System.out.println("\n--- 2. Unboxing (Wrapper -> Primitive) ---");
        
        // Modern Java AUTOMATICALLY extracts the primitive from the Object. This is Unboxing!
        int backToInt = wrappedInt; 
        System.out.println("Unboxed primitive value: " + backToInt);

        System.out.println("\n--- 3. Using them in Collections ---");
        List<Double> doubleList = new ArrayList<>();
        
        // Here, 10.5 is a primitive double. Java automatically autoboxes it into a Double Object
        // so it can safely go into the List.
        doubleList.add(10.5); 
        
        System.out.println("List containing Wrapper object: " + doubleList);
    }
}
