/**
 * INTERVIEWER: Explain Abstraction using Abstract Class and Interface.
 * 
 * CANDIDATE: Abstraction is hiding implementation details and showing only functionality.
 *
 * PROPER EXPLANATION:
 * 1. Abstract Class (P-75% Abstraction): Can have abstract methods (no body) and concrete methods. 
 *    Used for related objects (Dog, Cat are Animals). Can have state (fields).
 * 2. Interface (100% Abstraction): Before Java 8, it only had constants and abstract methods. 
 *    Used for unrelated objects that share a capability (Airplane and Bird can 'Fly').
 */

interface Flyable {
    void fly(); // Abstract by default
}

abstract class Bird {
    String species;
    Bird(String s) { this.species = s; }
    
    // Abstract method: Force children to implement
    abstract void sound();
    
    // Concrete method: Common logic
    void display() { System.out.println("This is a " + species); }
}

class Eagle extends Bird implements Flyable {
    Eagle() { super("Eagle"); }
    
    void sound() { System.out.println("Eagle Screech!"); }
    
    public void fly() { System.out.println("Eagle is flying high in the sky."); }
}

public class Q4_Abstraction {
    public static void main(String[] args) {
        Eagle e = new Eagle();
        e.display();
        e.sound();
        e.fly();
    }
}
