package TestJava.Test61;

// 1. Static Imports allow us to use static members (fields and methods)
// of another class WITHOUT prefixing them with the class name!
import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.System.out;

// You can also use wildcards: import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        // Look ma, no "System."!
        out.println("=== Static Imports Tutorial ===\n");

        int radius = 5;

        // Traditional Way:
        // double area = Math.PI * Math.pow(radius, 2);
        
        // With Static Imports (Cleaner reading):
        double area = PI * pow(radius, 2);

        out.println("Radius: " + radius);
        out.println("Area: " + area);
        
        // Summary: 
        // Use static imports sparingly! Overusing them can confuse other developers
        // about where methods like pow() or constants like PI are coming from.
        // It is great for highly mathematical classes or unit testing frameworks (like JUnit's assertEquals).
    }
}
