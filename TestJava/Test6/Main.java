package TestJava.Test6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Exception Handling Tutorial ===");

        // 1. Basic Try-Catch-Finally (Unchecked Exception - ArithmeticException)
        System.out.println("\n--- 1. Basic Try-Catch-Finally ---");
        try {
            int result = 10 / 0; // This will throw an ArithmeticException
            System.out.println("Result: " + result); // This line is never reached
        } catch (ArithmeticException e) {
            System.out.println("Caught an Exception! You cannot divide by zero.");
            // e.printStackTrace(); // Helpful for debugging
        } finally {
            System.out.println("Finally block ALWAYS executes, regardless of whether an exception occurred.");
        }

        // 2. Checked Exceptions (e.g., File I/O requires explicit handling)
        System.out.println("\n--- 2. Checked Exceptions ---");
        try {
            File file = new File("non_existent_file.txt");
            Scanner scanner = new Scanner(file); 
        } catch (FileNotFoundException e) {
            System.out.println("Caught a Checked Exception! The file was not found on the system.");
        }

        // 3. Throwing a Custom Exception
        System.out.println("\n--- 3. Custom Exceptions ---");
        try {
            checkVotingAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }

        System.out.println("\nProgram reached the end successfully!");
    }

    /**
     * The 'throws' keyword warns anyone calling this method that it might throw
     * this specific Checked Exception. They must either catch it or throw it further.
     */
    public static void checkVotingAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // 'throw' is used to actually generate and trigger the exception
            throw new InvalidAgeException("Age is " + age + ". Must be at least 18 to vote.");
        }
        System.out.println("Age is valid. You can vote.");
    }
}
