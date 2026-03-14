package TestJava.Test2;

/**
 * The Interface: Speaker
 * 
 * An interface can have 3 types of methods:
 * 1. Abstract: No body, child must implement.
 * 2. Default: Has a body, instances can use it.
 * 3. Static: Has a body, call it WITHOUT an object.
 */
public interface Speaker {
    
    // 1. Abstract Method (The standard way)
    void speak();

    // 2. Default Method (Added in Java 8)
    // Instances of the class can call this.
    default void announcement() {
        System.out.println("Speaker is making a general announcement...");
    }

    // 3. Static Method (Added in Java 8)
    // You call this WITHOUT creating any object!
    static void broadcast() {
        System.out.println("BROADCAST: Calling Speaker.broadcast() directly from the interface!");
    }
}
