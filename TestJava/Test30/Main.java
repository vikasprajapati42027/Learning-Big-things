package TestJava.Test30;

public class Main {
    
    // Varargs (Variable Arguments) allows a method to accept ZERO or MORE arguments.
    // Behind the scenes, Java treats it as an Array.
    // Rule 1: There can be only ONE vararg parameter per method.
    // Rule 2: It MUST be the LAST parameter in the method signature.
    public static void printShoppingList(String listName, String... items) {
        System.out.println("\n--- List: " + listName + " ---");
        
        if (items.length == 0) {
            System.out.println("   (List is empty)");
            return;
        }

        // 'items' behaves exactly like a String[] inside the method
        for (String item : items) {
            System.out.println(" * " + item);
        }
        System.out.println("Total items: " + items.length);
    }

    public static void main(String[] args) {
        System.out.println("=== Varargs (Variable Arguments) Tutorial ===");

        // We can pass zero items
        printShoppingList("Monday Errands");

        // We can pass one item
        printShoppingList("Tuesday Groceries", "Milk");

        // We can pass multiple items, just separated by commas!
        printShoppingList("Weekend Bash", "Pizza", "Soda", "Chips", "Salsa");

        // We can even pass an actual array if we want to
        String[] formalArray = {"Apples", "Bananas"};
        printShoppingList("Fruit Stock", formalArray);
    }
}
