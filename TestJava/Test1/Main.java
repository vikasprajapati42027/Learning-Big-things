package TestJava.Test1;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== OOP Basics Tutorial ===");

        // 1. Encapsulation in action
        Dog myDog = new Dog("Buddy", 3);
        System.out.println("Dog Name: " + myDog.getName()); // Using getter

        // 2. Inheritance
        // Dog has access to methods from Animal (getName) and Pet (play)
        
        // 3. Polymorphism
        myDog.makeSound(); // Dog's specific sound
        myDog.play();      // Dog's specific play style

        // 4. Abstraction
        // Look! We are using 'Animal' as the type, but the object is a 'Dog'.
        Animal polymorphicAnimal = new Dog("Charlie", 5);
        polymorphicAnimal.makeSound(); // Still says Woof because it's a Dog!
        
        System.out.println("\nAll four pillars demonstrated successfully!");
    }
}
