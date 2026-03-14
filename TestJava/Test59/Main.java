package TestJava.Test59;

class Parent {
    // Hidden Variable (because of inheritance)
    String name = "ParentName";
    
    public void printName() {
        System.out.println("Parent Method says: " + name);
    }
}

class Child extends Parent {
    // 1. Variable Hiding: Child declares a variable with the EXACT SAME NAME as the Parent.
    // Unlike methods, fields are NOT overridden, they are HIDDEN based on the REFERENCE type.
    String name = "ChildName";

    // 2. Variable Shadowing: A local variable inside a method has the exact same name as an instance variable.
    public void demonstrateShadowing() {
        String name = "LocalMethodName"; // This 'shadows' the instance variable
        
        System.out.println("Local Name: " + name); 
        System.out.println("Instance Name (using 'this'): " + this.name);
        System.out.println("Parent Name (using 'super'): " + super.name);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Variable Shadowing & Hiding Tutorial ===\n");

        System.out.println("--- 1. Variable Shadowing ---");
        Child childObj = new Child();
        childObj.demonstrateShadowing();

        System.out.println("\n--- 2. Variable Hiding (Tricky!) ---");
        // Using Polymorphism: Parent reference pointing to a Child object
        Parent polyRef = new Child();
        
        // When calling a METHOD, it's determined at RUNTIME (Child's method runs if overridden)
        // BUT polyRef doesn't override printName(), so Parent's method runs and returns "ParentName"
        polyRef.printName(); 
        
        // When accessing a FIELD directly, it's determined at COMPILE TIME!
        // Because the reference is 'Parent', it grabs the Parent's 'name' variable, NOT the Child's!
        System.out.println("Direct field access via Parent reference: " + polyRef.name); 
        
        // If we access it via Child reference:
        System.out.println("Direct field access via Child reference : " + childObj.name); 
    }
}
