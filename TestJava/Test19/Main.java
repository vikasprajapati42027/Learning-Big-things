package TestJava.Test19;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Pattern Matching (Java 16+) ===");

        Shape myShape1 = new Circle(5.0);
        Shape myShape2 = new Rectangle(4.0, 6.0);
        Object myString = "Not a shape!";

        System.out.println("\n--- 1. The Old Way (Pre-Java 16) ---");
        // We had to check the type, and then explicitly cast it within the if-block to use its methods
        if (myShape1 instanceof Circle) {
            Circle oldCircle = (Circle) myShape1;
            System.out.println("Old Way - Circle Radius: " + oldCircle.getRadius());
        }

        System.out.println("\n--- 2. Pattern Matching for instanceof (Java 16+) ---");
        // The type is checked AND casted to the variable 'c' in one single step!
        if (myShape1 instanceof Circle c) {
            System.out.println("Pattern Matching - Circle Radius: " + c.getRadius());
            System.out.println("Pattern Matching - Circle Area: "   + c.getArea());
        }

        System.out.println("\n--- 3. Using it dynamically in a method ---");
        printShapeDetails(myShape1);
        printShapeDetails(myShape2);
        printShapeDetails((Shape) () -> 0); // Anonymous shape
    }

    private static void printShapeDetails(Shape shape) {
        // Look how clean this is! No casting required.
        if (shape instanceof Circle c) {
            System.out.println("It's a Circle with radius " + c.getRadius());
        } else if (shape instanceof Rectangle r) {
            System.out.println("It's a Rectangle with dimensions " + r.getWidth() + "x" + r.getHeight());
        } else {
            System.out.println("Unknown Shape! Area: " + shape.getArea());
        }
    }
}
