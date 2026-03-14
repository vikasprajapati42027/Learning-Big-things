/**
 * Interviewer: What are Sealed Classes in Java 17?
 * Candidate: Sealed classes and interfaces restrict which other classes or interfaces may extend or implement them.
 */

// Sealed base class
sealed class Shape permits Circle, Square { }

// Final implementation
final class Circle extends Shape { }

// Non-sealed allows further extension
non-sealed class Square extends Shape { }

public class Q2_Sealed_Classes {
    public static void main(String[] args) {
        Shape shape = new Circle();
        System.out.println("Sealed classes provide better control over inheritance hierarchies.");
    }
}
