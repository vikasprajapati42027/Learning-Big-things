package TestJava.Test177;

// 1. The Element Interface
interface ItemElement {
    int accept(ShoppingCartVisitor visitor); // The magic method!
}

// 2. Concrete Elements
class Book implements ItemElement {
    private int price;
    private String isbnNumber;

    public Book(int price, String isbnNumber) { this.price = price; this.isbnNumber = isbnNumber; }
    public int getPrice() { return price; }
    public String getIsbnNumber() { return isbnNumber; }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this); // Passes ITSELF to the visitor!
    }
}

class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int priceKg, int wt, String name) { this.pricePerKg=priceKg; this.weight=wt; this.name = name; }
    public int getPricePerKg() { return pricePerKg; }
    public int getWeight() { return weight; }
    public String getName() { return this.name; }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this); 
    }
}

// 3. The Visitor Interface (Defines operations for EVERY concrete element)
interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}

// 4. Concrete Visitor (The Algorithm separated from the data structure)
class ShoppingCartVisitorImpl implements ShoppingCartVisitor {
    @Override
    public int visit(Book book) {
        int cost = book.getPrice();
        // apply $5 discount if book price is greater than 50
        if (cost > 50) cost -= 5;
        System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost =" + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = " + cost);
        return cost;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 177: Visitor Pattern ===\n");

        System.out.println("Allows adding new operations to existing data structures WITHOUT modifying them.");
        System.out.println("Heavily used in Compilers to walk Abstract Syntax Trees (ASTs)!\n");

        ItemElement[] items = new ItemElement[] {
            new Book(20, "1234"),
            new Book(100, "5678"),
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple")
        };

        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        
        int total = 0;
        for (ItemElement item : items) {
            total = total + item.accept(visitor);
        }
        
        System.out.println("\nTotal Cost = " + total);
    }
}
