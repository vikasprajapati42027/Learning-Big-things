package TestJava.Test51;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== String Formatting Tutorial ===\n");

        String name = "Alice";
        int age = 28;
        double salary = 75000.50;

        // --- 1. System.out.printf ---
        // '%s' = String, '%d' = Integer, '%f' = Floating point (double/float)
        System.out.println("--- 1. Using printf (Print Format) ---");
        System.out.printf("Name: %s, Age: %d, Salary: $%f%n", name, age, salary);
        
        // Formatting options:
        // %.2f -> 2 decimal places
        // %10s -> Right-align string within 10 spaces
        // %-10s -> Left-align string within 10 spaces
        System.out.printf("Formatted Salary: $%.2f%n", salary);
        System.out.printf("Right Aligned : |%10s|%n", name);
        System.out.printf("Left Aligned  : |%-10s|%n", name);

        // --- 2. String.format ---
        // Exactly like printf, but it RETURNS a formatted String instead of printing it directly.
        System.out.println("\n--- 2. Using String.format ---");
        String formattedMessage = String.format("Employee %s earns $%.2f per year.", name, salary);
        System.out.println("Saved Message: " + formattedMessage);
    }
}
