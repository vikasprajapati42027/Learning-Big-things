package TestJava.Test9;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Generics Tutorial ===");
        
        // 1. Box holding an Integer
        // Notice we MUST use the Wrapper class (Integer), not the primitive (int)
        Box<Integer> integerBox = new Box<>();
        integerBox.set(100);
        System.out.println("Integer Box contains: " + integerBox.get());
        
        // 2. Box holding a String
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics!");
        System.out.println("String Box contains: " + stringBox.get());
        
        System.out.println("\n--- Generic Methods ---");
        // We pass a Double object to the generic method of the integer Box
        integerBox.inspect(10.5); 
        
        // 3. Why are Generics important? (Type Safety at compile time)
        // Before Generics (Java 4 and older), we used 'Object':
        // Box oldBox = new Box(); 
        // oldBox.set("Apple");
        // Integer x = (Integer) oldBox.get(); // THIS WOULD CRASH AT RUNTIME (ClassCastException)
        
        // With Generics:
        // integerBox.set("Apple"); // The compiler catches this ERROR immediately! 
    }
}
