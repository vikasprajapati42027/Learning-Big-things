package TestJava.Test65;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// The 'var' keyword was introduced in Java 10 for Local-Variable Type Inference.
// It allows the compiler to GUESS the type of a variable based on the value assigned to it.
public class Main {
    
    // ERROR: 'var' CANNOT be used for instance variables or class properties!
    // var name = "Global"; 

    public static void main(String[] args) {
        System.out.println("=== The 'var' Keyword (Java 10+) ===\n");

        System.out.println("--- 1. Basic Type Inference ---");
        // Old Way:
        String oldString = "Hello";
        int oldNumber = 100;

        // New Way (Compiler knows what they are based on the right side!)
        // Once inferred, the type is FIXED. 'var' does NOT make Java dynamically typed like JavaScript.
        var newString = "Hello"; 
        var newNumber = 100;     
        var isJavaCool = true;   

        System.out.println("newString is inferred as String: " + newString);
        System.out.println("newNumber is inferred as int: " + newNumber);

        // ERROR: Cannot change type later!
        // newNumber = "Text"; // Fails to compile because newNumber is strictly an integer

        System.out.println("\n--- 2. Where 'var' is actually useful ---");
        // 'var' is great for making complex generic types easier to read.

        // Old Way (Lots of boilerplate text):
        Map<String, List<Integer>> oldMap = new HashMap<String, List<Integer>>();

        // New Way (Clean and readable):
        var newMap = new HashMap<String, List<Integer>>();
        newMap.put("Scores", new ArrayList<>(List.of(90, 85, 100)));
        System.out.println("Complex Map: " + newMap);

        System.out.println("\n--- 3. Using 'var' in Loops ---");
        var names = List.of("Alice", "Bob", "Charlie");
        
        for (var name : names) { // Compiler knows 'name' is a String
            System.out.println("Hello, " + name);
        }
    }
}
