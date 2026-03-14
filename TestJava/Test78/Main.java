package TestJava.Test78;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== NavigableSet & TreeSet Tutorial ===\n");

        // TreeSet implements NavigableSet. It automatically sorts its elements 
        // and provides amazing methods for finding elements RELATIVE to a target!

        NavigableSet<Integer> scores = new TreeSet<>();
        scores.add(10);
        scores.add(50);
        scores.add(30);
        scores.add(80);
        scores.add(100);

        System.out.println("TreeSet is naturally sorted: " + scores);

        // --- Relative Lookups ---
        System.out.println("\n--- Relative Lookups against Target [50] ---");
        
        // lower(): Strictly less than target (<)
        System.out.println("Lower than 50 (Strict): " + scores.lower(50)); // 30
        
        // floor(): Less than or equal to target (<=)
        System.out.println("Floor of 50 (Inclusive): " + scores.floor(50)); // 50
        
        // ceiling(): Greater than or equal to target (>=)
        System.out.println("Ceiling of 55 (Inclusive): " + scores.ceiling(55)); // 80
        
        // higher(): Strictly greater than target (>)
        System.out.println("Higher than 80 (Strict): " + scores.higher(80)); // 100

        // --- Extra Tricks ---
        System.out.println("\n--- Set Manipulations ---");
        System.out.println("Reverse Order Set: " + scores.descendingSet());
        
        // Extract a subset strictly between 20 and 90
        System.out.println("Subset between 20 & 90: " + scores.subSet(20, false, 90, true));
        
        // Extract lowest and highest reliably
        System.out.println("Lowest score (pollFirst): " + scores.pollFirst()); // Removes and returns 10
        System.out.println("Highest score (pollLast): " + scores.pollLast());  // Removes and returns 100
    }
}
