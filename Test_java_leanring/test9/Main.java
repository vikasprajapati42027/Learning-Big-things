package Test_java_leanring.test9;

/**
 * test9 - Exception handling: try-catch to handle errors.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test9: Exception handling ===");

        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println("Program continues after catch.");
    }
}
