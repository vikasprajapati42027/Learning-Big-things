package TestJava.Test145;

// 1. The Base Interface
interface Coffee {
    String getDescription();
    double getCost();
}

// 2. The Concrete Component (The 'Core' object we want to decorate)
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() { return "Basic Roasted Coffee"; }
    
    @Override
    public double getCost() { return 2.00; }
}

// 3. The Base Decorator Class
// It implements the interface AND holds a reference to a Coffee object!
abstract class CoffeeDecorator implements Coffee {
    protected Coffee wrapper;
    
    public CoffeeDecorator(Coffee coffee) {
        this.wrapper = coffee;
    }
    
    public String getDescription() { return wrapper.getDescription(); }
    public double getCost() { return wrapper.getCost(); }
}

// 4. Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }

    @Override
    public String getDescription() { return wrapper.getDescription() + ", Milk"; }
    
    @Override
    public double getCost() { return wrapper.getCost() + 0.50; }
}

class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) { super(coffee); }

    @Override
    public String getDescription() { return wrapper.getDescription() + ", Caramel Drizzle"; }
    
    @Override
    public double getCost() { return wrapper.getCost() + 0.75; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Design Pattern: Decorator ===\n");

        System.out.println("The Decorator pattern attaches new behaviors to an object dynamically at runtime.");
        System.out.println("It is a flexible alternative to subclassing for extending functionality.\n");

        // 1. Just a basic coffee
        Coffee order1 = new BasicCoffee();
        System.out.println("Order 1: " + order1.getDescription() + " | Cost: $" + order1.getCost());

        // 2. Adding Milk (Wrapping the basic coffee)
        Coffee order2 = new MilkDecorator(new BasicCoffee());
        System.out.println("Order 2: " + order2.getDescription() + " | Cost: $" + order2.getCost());

        // 3. Adding Milk AND Caramel! (We can layer decorators endlessly!)
        Coffee order3 = new CaramelDecorator(new MilkDecorator(new BasicCoffee()));
        System.out.println("Order 3: " + order3.getDescription() + " | Cost: $" + order3.getCost());
        
        System.out.println("\nNote: Standard Java I/O uses this heavily! (e.g., BufferedReader wraps an InputStreamReader)");
    }
}
