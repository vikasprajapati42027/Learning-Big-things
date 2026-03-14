package TestJava.Test1;

/**
 * 4. INHERITANCE & POLYMORPHISM
 * 
 * Inheritance: Dog 'extends' Animal (Dog gets name, age, and methods for free).
 * Implementation: Dog 'implements' Pet (Dog must play).
 */
public class Dog extends Animal implements Pet {

    public Dog(String name, int age) {
        super(name, age); // Calls the Parent (Animal) constructor
    }

    // 5. POLYMORPHISM (Method Overriding)
    // The same method 'makeSound' behaves differently in Dog than in Cat.
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof! Woof!");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is chasing a ball! 🎾");
    }
}
