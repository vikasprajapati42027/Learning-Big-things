package TestJava.Test40;

class Address {
    String city;
    Address(String city) { this.city = city; }
}

// Implementing Cloneable tells Java this object CAN be cloned
class Person implements Cloneable {
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow Copy: Copies primitive values, but only the REFERENCE of objects!
    public Person shallowCopy() throws CloneNotSupportedException {
        return (Person) super.clone(); // The default clone() is shallow
    }

    // Deep Copy: We manually clone the nested objects too!
    public Person deepCopy() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = new Address(this.address.city); // Create a BRAND NEW Address object
        return cloned;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Shallow vs Deep Copy ===");

        Person original = new Person("Vikas", new Address("Delhi"));

        System.out.println("\n--- 1. Shallow Copy ---");
        Person shallow = original.shallowCopy();
        // Changing the city in the clone affects the ORIGINAL because they share the same Address object!
        shallow.address.city = "Mumbai";
        System.out.println("Original City after Shallow change: " + original.address.city); // Mumbai!

        // Reset
        original.address.city = "Delhi";

        System.out.println("\n--- 2. Deep Copy ---");
        Person deep = original.deepCopy();
        // Changing the city in the clone does NOT affect the original!
        deep.address.city = "Bangalore";
        System.out.println("Original City after Deep change: " + original.address.city); // Still Delhi!
        System.out.println("Deep Clone City: " + deep.address.city); // Bangalore
    }
}
