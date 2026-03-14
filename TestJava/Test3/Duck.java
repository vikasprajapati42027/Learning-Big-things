package TestJava.Test3;

/**
 * Multiple Implementation: Duck
 * 
 * In Java, you can only 'extend' ONE class, 
 * but you can 'implement' MULTIPLE interfaces!
 */
public class Duck implements Flyable, Swimmable {

    @Override
    public void fly() {
        System.out.println("Duck is flapping wings and flying high! 🦆☁️");
    }

    @Override
    public void swim() {
        System.out.println("Duck is paddling in the water! 🦆🌊");
    }
}
