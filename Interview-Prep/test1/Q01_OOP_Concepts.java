// Q1: Explain the 4 OOP Concepts with examples

// 1. ENCAPSULATION — Hide internal state, expose only what is needed
class BankAccount {
    private double balance; // Hidden!

    public void deposit(double amount) {
        if (amount > 0) balance += amount;  // Controlled access
    }
    public double getBalance() { return balance; } // Controlled read
}

// 2. INHERITANCE — Child class reuses parent's code
class Animal { void speak() { System.out.println("..."); } }
class Dog extends Animal { @Override void speak() { System.out.println("Woof!"); } }
class Cat extends Animal { @Override void speak() { System.out.println("Meow!"); } }

// 3. POLYMORPHISM — Same method, different behavior based on object type
class Test_Polymorphism {
    static void makeSpeak(Animal a) {
        a.speak(); // Dog.speak() or Cat.speak() — decided at RUNTIME
    }
    public static void main(String[] args) {
        makeSpeak(new Dog()); // Woof!
        makeSpeak(new Cat()); // Meow!
    }
}

// 4. ABSTRACTION — Show WHAT (interface), hide HOW (implementation)
interface PaymentGateway {
    boolean pay(double amount); // What to do
}
class StripeGateway implements PaymentGateway {
    @Override public boolean pay(double amount) {
        System.out.println("Paying " + amount + " via Stripe API...");
        return true; // How to do it — hidden from caller
    }
}
