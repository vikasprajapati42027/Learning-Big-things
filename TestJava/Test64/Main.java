package TestJava.Test64;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Collection Factory Methods (Java 9+) ===\n");

        // Before Java 9, creating an unmodifiable collection was tedious:
        // List<String> list = new ArrayList<>();
        // list.add("A"); list.add("B");
        // list = Collections.unmodifiableList(list);

        // --- Java 9+ Factory Methods ---
        // These methods create IMMUTABLE (unmodifiable) collections instantly!
        // If you try to add/remove/put items later, they throw UnsupportedOperationException.
        // They also DO NOT ALLOW NULL VALUES!

        // 1. List.of()
        System.out.println("--- 1. List.of() ---");
        List<String> colors = List.of("Red", "Green", "Blue");
        System.out.println("Immutable List: " + colors);
        // colors.add("Yellow"); // crashes!

        // 2. Set.of()
        System.out.println("\n--- 2. Set.of() ---");
        Set<Integer> luckyNumbers = Set.of(7, 13, 42); // Rejects duplicates at creation!
        System.out.println("Immutable Set: " + luckyNumbers);

        // 3. Map.of()
        // Format: Key1, Value1, Key2, Value2... (Up to 10 pairs)
        System.out.println("\n--- 3. Map.of() ---");
        Map<String, Integer> scores = Map.of(
            "Alice", 95,
            "Bob", 82,
            "Charlie", 100
        );
        System.out.println("Immutable Map: " + scores);
        
        // 4. Map.ofEntries()
        // Better for maps with MORE than 10 pairs.
        System.out.println("\n--- 4. Map.ofEntries() ---");
        Map<String, String> capitals = Map.ofEntries(
            Map.entry("France", "Paris"),
            Map.entry("Japan", "Tokyo"),
            Map.entry("India", "New Delhi")
        );
        System.out.println("Map via Entries: " + capitals);
    }
}
