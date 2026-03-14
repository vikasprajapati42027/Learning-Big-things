package TestJava.Test79;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== NavigableMap & TreeMap Tutorial ===\n");

        // TreeMap implements NavigableMap. Similar to TreeSet, it keeps KEYS sorted
        // and allows relative lookups. Highly useful for routing rules, grade ranges, etc.!

        NavigableMap<Integer, String> employeeLevels = new TreeMap<>();
        employeeLevels.put(1, "Intern");
        employeeLevels.put(3, "Junior Developer");
        employeeLevels.put(5, "Senior Developer");
        employeeLevels.put(10, "Principal Architect");

        System.out.println("Sorted Map by Keys: " + employeeLevels);

        System.out.println("\n--- Relative Map Lookups against Target [4] ---");
        // What is the closest level role to level 4?
        
        // floorEntry(): Find the closest key LESS THAN OR EQUAL TO 4
        System.out.println("Floor Entry for Level 4: " + employeeLevels.floorEntry(4)); // (3=Junior Developer)
        
        // ceilingEntry(): Find the closest key GREATER THAN OR EQUAL TO 4
        System.out.println("Ceiling Entry for Level 4: " + employeeLevels.ceilingEntry(4)); // (5=Senior Developer)

        // --- Descending Maps ---
        System.out.println("\n--- Map Manipulations ---");
        System.out.println("Reverse Order Map: " + employeeLevels.descendingMap());
        
        // Extract all roles for Level 5 and above (Inclusive)
        System.out.println("TailMap (>= 5): " + employeeLevels.tailMap(5, true));
    }
}
