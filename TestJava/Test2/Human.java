package TestJava.Test2;

/**
 * Style 1: The Standard Way
 * A named class that 'implements' the interface.
 */
public class Human implements Speaker {
    @Override
    public void speak() {
        System.out.println("Human says: Hello, I am implementing Speaker normally!");
    }
}
