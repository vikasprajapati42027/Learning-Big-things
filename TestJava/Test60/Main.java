package TestJava.Test60;

import java.util.Objects;

// By default, every class in Java inherits from 'Object'.
// We should frequently override 'equals', 'hashCode', and 'toString'.
class Product {
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 1. toString(): Returns a readable string representation of the object.
    // By default, it prints something useless like: "TestJava.Test60.Product@2a139a55"
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "'}";
    }

    // 2. equals(): Defines what makes two Product objects "logically equal".
    // By default, it uses '==', meaning they must be the exact same object in memory!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Exact same memory reference?
        if (o == null || getClass() != o.getClass()) return false; // Null or different class?
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    // 3. hashCode(): Returns an integer hash. 
    // RULE: If two objects are equals(), they MUST have the same hashCode()!
    // Very important if you put these objects into a HashSet or HashMap!
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Object Methods (equals, hashCode, toString) ===\n");

        Product p1 = new Product(101, "Laptop");
        Product p2 = new Product(101, "Laptop"); // Logically identical, different memory Address
        Product p3 = p1; // Exact same memory address

        System.out.println("--- 1. toString() ---");
        System.out.println(p1); // Implicitly calls p1.toString()

        System.out.println("\n--- 2. equals() vs '==' ---");
        // '==' always checks memory references!
        System.out.println("p1 == p2 (Memory Ref Check) : " + (p1 == p2)); // false
        System.out.println("p1 == p3 (Memory Ref Check) : " + (p1 == p3)); // true
        
        // '.equals()' uses our custom logical check!
        System.out.println("p1.equals(p2) (Logical Check) : " + p1.equals(p2)); // TRUE!

        System.out.println("\n--- 3. hashCode() ---");
        System.out.println("p1 Hash: " + p1.hashCode());
        System.out.println("p2 Hash: " + p2.hashCode()); // Notice they match because they are equal!
    }
}
