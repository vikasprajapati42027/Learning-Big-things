package TestJava.Test76;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PriorityQueue Tutorial ===\n");

        // A PriorityQueue doesn't follow normal FIFO (First-In, First-Out).
        // It orders elements according to their "natural ordering" or a custom Comparator.
        // The element with the HIGHEST priority (lowest value naturally) is always at the front!

        // 1. Natural Ordering (Integers)
        System.out.println("--- 1. Natural Priority (Smallest First) ---");
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(100);
        numbers.add(20);

        System.out.println("Internally it looks chaotic: " + numbers); // Not fully sorted internally, just a heap!
        
        System.out.println("Retrieving in Priority Order:");
        while (!numbers.isEmpty()) {
            System.out.print(numbers.poll() + " "); // .poll() extracts the highest priority (smallest number)
        }
        System.out.println("\n");

        // 2. Custom Ordering (Strings by Length)
        System.out.println("--- 2. Custom Priority (Longest String First) ---");
        
        // Custom Comparator: sort by length descending
        PriorityQueue<String> words = new PriorityQueue<>((s1, s2) -> Integer.compare(s2.length(), s1.length()));
        words.add("Apple");
        words.add("Watermelon");
        words.add("Fig");
        words.add("Banana");

        while (!words.isEmpty()) {
            System.out.println("Extracted: " + words.poll());
        }
    }
}
