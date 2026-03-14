package TestJava.Test34;

class Animal {}
class Dog extends Animal {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== instanceof vs getClass() ===");
        
        Animal myDog = new Dog();
        
        // 1. instanceof
        // Checks if the object "IS A" type of a specific class or ANY of its parent classes/interfaces.
        System.out.println("\n--- 1. Using instanceof ---");
        System.out.println("myDog instanceof Dog: " + (myDog instanceof Dog));       // true
        System.out.println("myDog instanceof Animal: " + (myDog instanceof Animal)); // true (Because Dog IS AN Animal)
        System.out.println("myDog instanceof Object: " + (myDog instanceof Object)); // true (Everything is an Object)

        // 2. getClass()
        // Checks the EXACT runtime class of the object. Does NOT consider inheritance!
        System.out.println("\n--- 2. Using getClass() ---");
        System.out.println("myDog.getClass() == Dog.class: " + (myDog.getClass() == Dog.class));       // true
        System.out.println("myDog.getClass() == Animal.class: " + (myDog.getClass() == Animal.class)); // FALSE! It's exactly a Dog, not a generic Animal.
        
        // Summary: 
        // Use 'instanceof' when you want to know if an object can act like a specific type (supports polymorphism).
        // Use 'getClass()' when you need to know the EXACT strict type without inheritance.
    }
}
