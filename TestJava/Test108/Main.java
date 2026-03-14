package TestJava.Test108;

// Java 16+ introduced Records as a standard feature!
record Point(int x, int y) {}
record Circle(Point center, int radius) {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Records (Java 16+) ===\n");

        Point p = new Point(10, 20);
        Circle c = new Circle(new Point(5, 5), 100);

        System.out.println("--- 1. Using Records Automatically ---");
        // toString(), equals(), and hashCode() are all generated automatically!
        System.out.println("Point: " + p);
        
        // Instead of p.getX(), we use p.x()
        System.out.println("Point X Coordinate: " + p.x());

        System.out.println("\n--- 2. Record Pattern Concepts (Java 21 Preview) ---");
        System.out.println("Circle Center: " + c.center());
        
        // In Java 17, we extract values manually (using an Object reference to avoid redundant pattern match errors):
        Object objCenter = c.center();
        if (objCenter instanceof Point centerPoint) {
            System.out.println("Center X: " + centerPoint.x());
        }
        
        System.out.println("Note: In Java 21+, we can 'deconstruct' records directly in instanceof and switch statements:");
        System.out.println("e.g. `if (c instanceof Circle(Point(int x, int y), int r))`");
    }
}
