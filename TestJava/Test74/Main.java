package TestJava.Test74;

// Records provide immense value over normal classes.
// But what if we need to VALIDATE data before the record is created?
// Instead of writing a massive constructor, we use a "Compact Constructor".

record ProductRecord(String name, double price, int stock) {
    
    // COMPACT CONSTRUCTOR
    // Notice it doesn't have parenthesis ( ) or arguments!
    // It automatically has access to 'name', 'price', and 'stock' before they are assigned.
    public ProductRecord {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative: " + price);
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative: " + stock);
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product must have a non-empty name!");
        }
        
        // We can even sanitize data before assignment!
        name = name.toUpperCase().trim();
        
        // The assignment `this.name = name;` etc happens AUTOMATICALLY at the end of this block!
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Record Validation Tutorial (Java 14+) ===\n");

        System.out.println("--- 1. Creating a Valid Record ---");
        ProductRecord p1 = new ProductRecord("   laptop  ", 999.99, 50);
        System.out.println(p1); // Notice the name was automatically trimmed and uppercased!

        System.out.println("\n--- 2. Creating an Invalid Record ---");
        try {
            ProductRecord p2 = new ProductRecord("Mouse", -10.0, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Validation Error: " + e.getMessage());
        }
        
        System.out.println("\nCompact Constructors keep validation logic clean and concise!");
    }
}
