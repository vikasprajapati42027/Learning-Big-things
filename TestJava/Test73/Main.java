package TestJava.Test73;

import java.util.ArrayList;
import java.util.List;

class Machine {
    public void start() {
        System.out.println("Machine Starting...");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Method References Deep Dive ===\n");

        List<String> words = new ArrayList<>(List.of("apple", "banana", "cherry"));

        // Let's recap the 4 types of Method References

        // --- 1. Static Method Reference ---
        System.out.println("--- 1. Static Method Reference ---");
        // Syntax: ClassName::staticMethodName
        words.stream()
             .map(String::toUpperCase) // Static method reference
             .forEach(System.out::println);

        // --- 2. Instance Method Reference of a specific object ---
        System.out.println("\n--- 2. Instance Method Reference ---");
        // Syntax: instance::methodName
        Prefixer prefixer = new Prefixer();
        words.stream()
             .map(prefixer::addPrefix) // Looking at the specific 'prefixer' object
             .forEach(System.out::println);

        // --- 3. Instance Method Review (Arbitrary Object of a Typed Class) ---
        System.out.println("\n--- 3. Arbitrary Instance Method Reference ---");
        List<Machine> machines = List.of(new Machine(), new Machine());
        
        // Syntax: ClassName::methodName
        // Even though start() is NOT static, Java knows we want to call it 
        // ON EACH object flowing through the stream!
        machines.forEach(Machine::start); 
    }
}

class Prefixer {
    public String addPrefix(String str) {
        return ">> " + str;
    }
}
