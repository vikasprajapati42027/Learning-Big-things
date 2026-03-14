/**
 * INTERVIEWER: Explain Inheritance and 'IS-A' relationship.
 * 
 * CANDIDATE: Inheritance allows a class to acquire the properties (fields) and behaviors (methods)
 * of another class. It promotes code reusability and establishes a natural hierarchy.
 *
 * PROPER EXPLANATION:
 * 1. Base/Parent Class: The class whose properties are inherited.
 * 2. Derived/Child Class: The class that inherits.
 * 3. 'extends' keyword: Used to perform inheritance.
 * 4. IS-A relationship: A Dog IS-A Animal. A Manager IS-A Employee.
 * 5. Feature: Child can add new methods and override existing ones.
 */

class Vehicle {
    protected String brand = "Generic";
    
    public void honk() {
        System.out.println("Tuut, tuut!");
    }
}

class Car extends Vehicle {
    private String modelName = "Mustang";
    
    public void displayInfo() {
        // Accessing base class field
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + modelName);
    }
}

public class Q2_Inheritance {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.honk();         // Method inherited from parent
        myCar.displayInfo();  // Method defined in child
    }
}
