/**
 * INTERVIEWER: What is the 'static' keyword and can we override static methods?
 * 
 * CANDIDATE: 'static' means the member belongs to the class, not instance objects. 
 * You cannot override static methods, only hide them.
 *
 * PROPER EXPLANATION:
 * 1. Static Variable: Shared across all instances (e.g., Company name).
 * 2. Static Method: Can be called without creating an object. 
 *    Cannot access instance variables (this/super).
 * 3. Static Block: Runs once when class is loaded by ClassLoader.
 * 4. Method Hiding: If a child defines a static method with same signature as parent's static method, 
 *    it's hiding, not overriding. Resolved at Compile-time.
 */

class University {
    static String name = "Global University"; // Shared
    String studentName; // Unique per instance

    static {
        System.out.println("University Class Loaded.");
    }

    static void changeName(String n) { name = n; }

    static void displayInfo() {
        System.out.println("University: " + name);
        // System.out.println(studentName); // COMPILATION ERROR: Static cannot access instance
    }
}

public class Q5_Static {
    public static void main(String[] args) {
        University.displayInfo();
        
        University u1 = new University();
        u1.studentName = "Vikas";
        
        University u2 = new University();
        u2.studentName = "John";
        
        System.out.println(u1.studentName + " and " + u2.studentName + " both study at " + University.name);
    }
}
