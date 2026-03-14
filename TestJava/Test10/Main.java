package TestJava.Test10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Collections Framework Tutorial ===");

        // 1. LIST (Ordered collection, allows duplicates)
        // Best for: Storing sequences, accessing elements by index
        System.out.println("\n--- 1. List (ArrayList) ---");
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Apples");
        shoppingList.add("Bananas");
        shoppingList.add("Milk");
        shoppingList.add("Apples"); // Duplicate allowed

        System.out.println("Shopping List (Allows duplicates): " + shoppingList);
        System.out.println("Item at index 1: " + shoppingList.get(1));

        // 2. SET (Unordered collection, NO duplicates allowed)
        // Best for: Ensuring uniqueness, checking if an item exists quickly
        System.out.println("\n--- 2. Set (HashSet) ---");
        Set<String> uniqueIds = new HashSet<>();
        uniqueIds.add("USER123");
        uniqueIds.add("USER456");
        uniqueIds.add("USER789");
        uniqueIds.add("USER123"); // This duplicate will be ignored!

        System.out.println("Unique IDs (No duplicates): " + uniqueIds);

        // 3. MAP (Key-Value pairs, Keys must be unique, Values can be duplicated)
        // Best for: Lookups, caching, associating one piece of data with another
        // Note: Map is part of the Collections Framework but does NOT extend the Collection interface!
        System.out.println("\n--- 3. Map (HashMap) ---");
        Map<String, Integer> studentGrades = new HashMap<>();
        studentGrades.put("Alice", 95);
        studentGrades.put("Bob", 80);
        studentGrades.put("Charlie", 95); // Duplicate values are fine
        studentGrades.put("Bob", 85);     // Using same key silently OVERWRITES the old value

        System.out.println("Student Grades (Key-Value pairs): " + studentGrades);
        System.out.println("Bob's final grade: " + studentGrades.get("Bob"));

        System.out.println("\nAll 3 major collection types demonstrated successfully!");
    }
}
