/**
 * INTERVIEWER: What is the Diamond Problem and how does Java handle it?
 * 
 * CANDIDATE: The Diamond Problem occurs in multiple inheritance where a class inherits 
 * from two parents that have the same method. Java avoids this for classes by forbidding 
 * multiple inheritance. However, with Java 8's "Default Methods" in interfaces, it can occur.
 * 
 * PROPER EXPLANATION:
 * 1. Why no multiple inheritance for classes? Ambiguity in which parent's field/method to use.
 * 2. Interfaces: Since Java 8, interfaces can have body in 'default' methods.
 * 3. Solution: The implementing class MUST override the conflicting method and specify 
 * which parent to call using super syntax: 'InterfaceName.super.methodName()'.
 */

interface InterfaceA {
    default void message() {
        System.out.println("Message from Interface A");
    }
}

interface InterfaceB {
    default void message() {
        System.out.println("Message from Interface B");
    }
}

// Conflict: Both A and B have message()
class DiamondClass implements InterfaceA, InterfaceB {
    
    // The class is forced to override the conflicting method
    @Override
    public void message() {
        // Option 1: Provide own implementation
        System.out.println("Unique implementation in DiamondClass");
        
        // Option 2: Choose one of the parents explicitly
        InterfaceA.super.message();
        InterfaceB.super.message();
    }
}

public class Q10_DiamondProblem {
    public static void main(String[] args) {
        DiamondClass obj = new DiamondClass();
        obj.message();
    }
}
