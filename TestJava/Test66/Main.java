package TestJava.Test66;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// Java 8 introduced java.util.function package packed with 'Functional Interfaces'.
// Instead of writing custom interfaces (like our MathOperation from Test5), 
// we should use these standard ones!
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Built-in Functional Interfaces Tutorial ===\n");

        // --- 1. Predicate<T> ---
        // Takes an argument and returns a boolean (true/false).
        // Great for filtering lists!
        System.out.println("--- 1. Predicate<T> (Argument -> Boolean) ---");
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));

        // --- 2. Function<T, R> ---
        // Takes an argument (T) and returns a result (R). The types can be different.
        // Great for mapping/transforming data!
        System.out.println("\n--- 2. Function<T, R> (Argument -> Result) ---");
        Function<String, Integer> wordLength = text -> text.length();
        System.out.println("Length of 'Java': " + wordLength.apply("Java"));
        System.out.println("Length of 'Development': " + wordLength.apply("Development"));

        // --- 3. Consumer<T> ---
        // Takes an argument but returns NOTHING (void).
        // Great for executing actions (like printing, saving to DB).
        System.out.println("\n--- 3. Consumer<T> (Argument -> Void) ---");
        Consumer<String> greetingPrinter = name -> System.out.println("Hello there, " + name + "!");
        greetingPrinter.accept("Vikas");

        // --- 4. Supplier<T> ---
        // Takes NO arguments but returns a result.
        // Great for lazy generation or generating default values.
        System.out.println("\n--- 4. Supplier<T> (Void -> Result) ---");
        Supplier<Double> randomValueGenerator = () -> Math.random() * 100;
        System.out.println("Random Value 1: " + randomValueGenerator.get());
        System.out.println("Random Value 2: " + randomValueGenerator.get());
    }
}
