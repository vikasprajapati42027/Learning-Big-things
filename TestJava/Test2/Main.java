package TestJava.Test2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Interface Usage: 4 Ways to Call ===");

        // WAY 1: Standard Object (Using a named class)
        Speaker human = new Human();
        human.speak();
        human.announcement(); // Calling a default method on the object

        System.out.println("------------------------------------");

        // WAY 2: Anonymous Inner Class (Implementing on the fly)
        // Helps you avoid creating a separate file if you only need it once!
        Speaker robot = new Speaker() {
            @Override
            public void speak() {
                System.out.println("Robot says: Beep-Boop! I am an Anonymous implementation.");
            }
        };
        robot.speak();

        System.out.println("------------------------------------");

        // WAY 3: Lambda Expression (The modern, ultra-short code)
        // ONLY works if the interface has exactly ONE abstract method.
        Speaker alien = () -> System.out.println("Alien says: 👽 Greetings from Lambda World!");
        alien.speak();

        System.out.println("------------------------------------");

        // WAY 4: Static Method CALL (WITHOUT ANY OBJECT)
        // Notice we don't use 'new'. We call it directly on 'Speaker'.
        Speaker.broadcast();

        System.out.println("\nAll 4 ways demonstrated successfully!");
    }
}
