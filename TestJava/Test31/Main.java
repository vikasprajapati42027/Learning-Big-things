package TestJava.Test31;

public class Main {
    
    private String name;
    
    // The 'this' keyword refers to the CURRENT OBJECT executing the method/constructor.
    
    // 1. Using 'this' to resolve ambiguity between instance variables and parameters
    public Main(String name) {
        // Without 'this.name', Java assumes you mean the parameter 'name'
        this.name = name; 
    }
    
    // 2. Using 'this()' to call another constructor in the SAME class
    public Main() {
        this("Default Name"); // This calls the constructor that takes a String!
    }
    
    // 3. Using 'this' to pass the current object to another method
    public void printInfo() {
        System.out.println("Processing object...");
        processObject(this); // Passing MYSELF to another method
    }
    
    private void processObject(Main obj) {
        System.out.println("Processed: " + obj.name);
    }
    
    public static void main(String[] args) {
        System.out.println("=== The 'this' Keyword ===");
        
        Main obj1 = new Main("Vikas");
        obj1.printInfo();
        
        Main obj2 = new Main();
        obj2.printInfo();
    }
}
