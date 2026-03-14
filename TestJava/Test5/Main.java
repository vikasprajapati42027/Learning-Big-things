package TestJava.Test5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Advanced Java Tutorial: Lambdas & Streams ===");

        // 1. LAMBDA EXPRESSIONS (Implementing a Functional Interface)
        System.out.println("\n--- Lambdas ---");
        
        // Define behaviors dynamically!
        MathOperation addition = (a, b) -> a + b;
        MathOperation multiplication = (a, b) -> a * b;

        addition.printOperation("Addition");
        System.out.println("10 + 5 = " + operateOnNumbers(10, 5, addition));

        multiplication.printOperation("Multiplication");
        System.out.println("10 * 5 = " + operateOnNumbers(10, 5, multiplication));

        // 2. JAVA STREAMS API (Powerful collection processing)
        System.out.println("\n--- Streams API ---");
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Amanda");

        System.out.println("Original List: " + names);

        // Filter names starting with 'A', convert to uppercase, and collect to a new list
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase) // Method Reference syntax
                .collect(Collectors.toList());

        System.out.println("Names starting with 'A' (Uppercase): " + filteredNames);

        // Count names longer than 3 characters
        long count = names.stream()
                .filter(name -> name.length() > 3)
                .count();

        System.out.println("Number of names longer than 3 letters: " + count);
    }

    // Helper method that takes a behavior (Lambda) as an argument
    private static int operateOnNumbers(int a, int b, MathOperation operation) {
        return operation.operate(a, b);
    }
}
