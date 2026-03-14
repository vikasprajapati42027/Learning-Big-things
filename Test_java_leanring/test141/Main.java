package Test_java_leanring.test141;

/** test141 - sealed interface (Java 17) */
sealed interface Shape permits Circle, Rectangle {}
record Circle(double r) implements Shape {}
record Rectangle(double w, double h) implements Shape {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test141: sealed ===");
        Shape s = new Circle(1.0);
        System.out.println(s);
    }
}
