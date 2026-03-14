/**
 * INTERVIEWER: What are Lambda Expressions and how do they impact Java?
 * 
 * CANDIDATE: Lambdas introduce functional programming to Java. They provide a concise 
 * way to represent a functional interface (interface with one abstract method).
 * 
 * PROPER EXPLANATION:
 * 1. Target Type: The compiler infers the type of a lambda from its context.
 * 2. Syntax: (parameters) -> { body }. If one parameter, () is optional.
 * 3. Scope: Lambdas can access variables from the outer scope if they are effectively final.
 * 4. Benefits: Reduces boilerplate code for anonymous classes and enables the Stream API.
 */

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class Q1_Lambda_Expression {
    public static void main(String[] args) {
        // 1. Defining behaviors using Lambdas
        MathOperation addition = (a, b) -> a + b;
        MathOperation multiplication = (a, b) -> a * b;

        System.out.println("Result (10 + 5): " + addition.operate(10, 5));
        System.out.println("Result (10 * 5): " + multiplication.operate(10, 5));

        // 2. Practical usage in Sorting
        List<String> list = new ArrayList<>(List.of("Vikas", "Dev", "Java"));
        list.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted by length: " + list);
    }
}
