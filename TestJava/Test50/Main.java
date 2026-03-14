package TestJava.Test50;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
    String type;
    double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Stream API: Reduce and Collect ===");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Transaction> transactions = Arrays.asList(
            new Transaction("GROCERY", 50.0),
            new Transaction("GROCERY", 20.0),
            new Transaction("ELECTRONICS", 200.0)
        );

        // --- 1. reduce() ---
        // Used to combine all elements of a stream into a SINGLE result.
        // Takes an initial value (identity) and an accumulator function.
        System.out.println("\n--- 1. Using reduce() ---");
        
        // Summing numbers: 0 + 1 + 2 + 3 + 4 + 5
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b); // Initial value 0
                // OR: .reduce(0, Integer::sum);
                
        System.out.println("Sum of numbers (1 to 5): " + sum);

        // Multiplying numbers: 1 * 1 * 2 * 3 * 4 * 5
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b); // Initial value 1
                
        System.out.println("Product of numbers (1 to 5): " + product);

        // --- 2. Advanced collect() ---
        // Used to transform stream elements into Collections or other aggregated structures.
        System.out.println("\n--- 2. Advanced collect() ---");
        
        // Grouping Transactions by Type AND summing their amounts
        Map<String, Double> totalByType = transactions.stream()
            .collect(Collectors.groupingBy(
                t -> t.type,                              // Group by the 'type' string
                Collectors.summingDouble(t -> t.amount)   // Sum the 'amount' field for each group
            ));

        System.out.println("Total Amount by Transaction Type:");
        totalByType.forEach((type, total) -> {
            System.out.println(" - " + type + ": $" + total);
        });

        // Joining Strings
        String joinedTypes = transactions.stream()
            .map(t -> t.type)
            .distinct()
            .collect(Collectors.joining(" & "));
            
        System.out.println("\nDistinct Transaction Types Joined: " + joinedTypes);
        
        System.out.println("\n=== Java Advanced Concepts Tour (1-50) Finished! ===");
    }
}
