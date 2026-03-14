package TestJava.Test32;

class Animal {
    String type = "Generic Animal";

    public Animal() {
        System.out.println("Animal created!");
    }

    public void makeSound() {
        System.out.println("Some generic animal sound...");
    }
}

class Dog extends Animal {
    String type = "Canine";

    // 1. 'super()' calls the constructor of the PARENT class. 
    // It's ALWAYS called implicitly, but you can call it explicitly.
    public Dog() {
        super(); // Calls Animal()
        System.out.println("Dog created!");
    }

    // 2. 'super.method()' calls a method from the PARENT class.
    @Override
    public void makeSound() {
        super.makeSound(); // Calls the generic sound first
        System.out.println("Woof! Woof!");
    }

    // 3. 'super.variable' accesses a field from the PARENT class.
    public void printTypes() {
        System.out.println("My type: " + this.type);
        System.out.println("Parent type: " + super.type);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== The 'super' Keyword ===");
        
        Dog myDog = new Dog();
        System.out.println("\n--- Make Sound ---");
        myDog.makeSound();
        
        System.out.println("\n--- Print Types ---");
        myDog.printTypes();
    }
}
