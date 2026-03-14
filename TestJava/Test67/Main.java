package TestJava.Test67;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Parallel Streams Tutorial ===\n");

        // Let's create a large list of numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("Processing 10 items. Notice the order of execution:\n");

        System.out.println("--- 1. Normal (Sequential) Stream ---");
        // Processes elements one by one, completely sequentially on a single thread.
        // Predictable order.
        numbers.stream().forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println("\n");

        System.out.println("--- 2. Parallel Stream ---");
        // Automatically splits the work across multiple threads depending on your CPU cores!
        // Unpredictable order, but GREAT for processing huge datasets (Millions of rows).
        numbers.parallelStream().forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println("\n");
        
        // --- 3. Gotchas with Parallel Streams ---
        // 1. DO NOT use parallelStream if order matters!
        // 2. DO NOT use parallelStream for tiny datasets (the overhead of managing threads makes it slower).
        // 3. DO NOT use parallelStream if the operations are modifying shared external variables (not thread-safe).
        
        System.out.println("Bonus: If order matters but you STILL want parallel processing, use .forEachOrdered():");
        numbers.parallelStream().forEachOrdered(n -> System.out.print(n + " "));
        System.out.println();
    }
}
