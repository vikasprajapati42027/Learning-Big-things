package TestJava.Test83;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Collections Utility Class ===\n");

        // The java.util.Collections class provides static methods
        // that operate on or return collections.

        List<Integer> numbers = new ArrayList<>(List.of(42, 12, 89, 5, 20));
        System.out.println("Original List: " + numbers);

        // 1. Min and Max
        System.out.println("\n--- Min & Max ---");
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));

        // 2. Sorting and Reversing
        System.out.println("\n--- Sorting & Reversing ---");
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);
        
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        // 3. Shuffling (Randomizing order)
        System.out.println("\n--- Shuffling ---");
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);

        // 4. Fill (Replace all elements with a single value)
        System.out.println("\n--- Fill ---");
        List<String> blanks = new ArrayList<>(List.of("", "", ""));
        Collections.fill(blanks, "Data");
        System.out.println("Filled List: " + blanks);
        
        // 5. Frequency and Disjoint
        System.out.println("\n--- Frequency & Disjoint ---");
        List<String> votes = List.of("Yes", "No", "Yes", "Yes", "No");
        System.out.println("Frequency of 'Yes': " + Collections.frequency(votes, "Yes"));
        
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5, 6);
        // disjoint returns true if the two collections have NO elements in common!
        System.out.println("Are list1 & list2 disjoint? " + Collections.disjoint(list1, list2));
    }
}
