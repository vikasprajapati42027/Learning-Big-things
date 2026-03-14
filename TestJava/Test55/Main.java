package TestJava.Test55;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== The 'Scanner' Class Tutorial ===\n");

        // Scanner is typically used to read input from the keyboard (System.in).
        // For this automated test, we will simulate user input by giving it a String instead!
        String simulatedUserInput = "Vikas\n25\n75.5\n";

        // Read from our simulated string. 
        // In a real app doing console input, you would use: new Scanner(System.in);
        try (Scanner scanner = new Scanner(simulatedUserInput)) {
            
            System.out.println("Simulating user input...");
            
            // Reading a String
            System.out.print("Enter your name: ");
            String name = scanner.nextLine(); // Reads the whole line until \n
            System.out.println(name);

            // Reading an Integer
            System.out.print("Enter your age: ");
            int age = scanner.nextInt(); 
            System.out.println(age);

            // Reading a Double
            System.out.print("Enter your weight (kg): ");
            double weight = scanner.nextDouble();
            System.out.println(weight);

            System.out.println("\n--- Summary ---");
            System.out.println("User Profile -> Name: " + name + ", Age: " + age + ", Weight: " + weight + "kg");

        } // The scanner is automatically closed here due to 'try-with-resources'
    }
}
