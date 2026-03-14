/**
 * INTERVIEWER: Differentiate between Compile-time and Runtime Polymorphism.
 * 
 * CANDIDATE: Polymorphism means "many forms". 
 * Static (Compile-time) is achieved by Method Overloading. 
 * Dynamic (Runtime) is achieved by Method Overriding.
 *
 * PROPER EXPLANATION:
 * 1. Overloading (Compile-time): Multiple methods with same name but different parameters. 
 *    Resolved by compiler based on signature.
 * 2. Overriding (Runtime): Method in child class with same name and signature as in parent. 
 *    Resolved by JVM at runtime based on the actual object type (Upcasting).
 */

class Shape {
    void draw() { System.out.println("Drawing a generic shape"); }
}

class Circle extends Shape {
    @Override
    void draw() { System.out.println("Drawing a Circle"); }
}

class Printer {
    // Overloading: Multiple forms of print
    void print(String s) { System.out.println("Printing string: " + s); }
    void print(int i) { System.out.println("Printing integer: " + i); }
}

public class Q3_Polymorphism {
    public static void main(String[] args) {
        // Compile-time Polymorphism (Overloading)
        Printer p = new Printer();
        p.print("Hello");
        p.print(100);

        // Runtime Polymorphism (Overriding + Upcasting)
        Shape s = new Circle(); 
        s.draw(); // Even though reference is Shape, Circle's draw() is called at Runtime
    }
}
