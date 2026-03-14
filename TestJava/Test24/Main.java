package TestJava.Test24;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Method & Constructor References (Java 8+) ===");

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // --- 1. Constructor Reference (Class::new) ---
        // Instead of writing a lambda: name -> new Person(name)
        // We just point directly to the Person constructor!
        System.out.println("\n--- 1. Constructor References ---");
        List<Person> people = names.stream()
            .map(Person::new) // Call the Person(String name) constructor for each string!
            .collect(Collectors.toList());

        // --- 2. Instance Method Reference of an Arbitrary Object (Class::methodName) ---
        // Instead of writing: person -> person.getName()
        System.out.println("\n--- 2. Instance Method Reference ---");
        List<String> extractedNames = people.stream()
            .map(Person::getName) // Call the getName() method on whatever Person object comes through
            .collect(Collectors.toList());
        System.out.println("Extracted Names: " + extractedNames);

        // --- 3. Static Method Reference (Class::staticMethodName) ---
        System.out.println("\n--- 3. Static Method Reference ---");
        
        // Let's sort people by their name length using the static method from Person
        // Lambda way: (p1, p2) -> Person.compareByNameLength(p1, p2)
        // Reference way: Person::compareByNameLength
        people.sort(Person::compareByNameLength);
        
        System.out.println("Sorted People (by name length): " + people);

        // --- 4. Instance Method Reference of a Particular Object (instance::methodName) ---
        System.out.println("\n--- 4. Specific Instance Method Reference ---");
        
        // System.out is an object instance. println is its method.
        // Instead of: p -> System.out.println(p)
        people.forEach(System.out::println); 
    }
}
