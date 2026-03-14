/**
 * INTERVIEWER: Explain the difference between 'this' and 'super'.
 * 
 * CANDIDATE: 'this' refers to the current object. 'super' refers to the immediate parent object.
 *
 * PROPER EXPLANATION:
 * 1. this: Access current class instance variables, methods, or constructor (this()).
 * 2. super: Access parent class variables, methods, or constructor (super()).
 * 3. Constructor Chaining: calling one constructor from another within the same class or from parent class.
 * 4. Priority: Constructors must have this() or super() as the VERY FIRST statement.
 */

class Parent {
    String name = "Parent";
    Parent() { System.out.println("Parent Constructor Called."); }
    Parent(String val) { System.out.println("Parent Parametrized: " + val); }
}

class Child extends Parent {
    String name = "Child";

    Child() {
        this("Default"); // Calls this class's parametrized constructor
        System.out.println("Child Default Constructor Called.");
    }

    Child(String n) {
        super("Initializing Parent"); // Calls parent's parametrized constructor
        System.out.println("Child Parametrized Constructor Called.");
    }

    void display() {
        System.out.println("Current Name (this): " + this.name);
        System.out.println("Parent Name (super): " + super.name);
    }
}

public class Q8_SuperThis {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}
