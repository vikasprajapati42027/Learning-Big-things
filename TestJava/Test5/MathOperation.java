package TestJava.Test5;

/**
 * Functional Interface: MathOperation
 * 
 * An interface with exactly ONE abstract method is called a Functional Interface.
 * It's perfect for Lambda expressions.
 */
@FunctionalInterface
public interface MathOperation {
    int operate(int a, int b);

    // Can still have default or static methods
    default void printOperation(String opName) {
        System.out.println("Executing operation: " + opName);
    }
}
