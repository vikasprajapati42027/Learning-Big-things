/**
 * Interview Prep: Test 5 - Java 8+ Features
 * 10 Simple Examples with Explanation
 */

// 1. Lambda Expressions
// A short way to write anonymous classes for functional interfaces.
import java.util.*;
import java.util.stream.*;

class Q1 {
    void demo() {
        Runnable r = () -> System.out.println("Lambda Run");
    }
}

// 2. Streams API
// Pipeline to process data (filter, map, collect).
class Q2 {
    void demo() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().filter(n -> n > 1).forEach(System.out::println);
    }
}

// 3. Functional Interfaces
// Interfaces with exactly one abstract method.
@FunctionalInterface
interface MyFunc { void execute(); }

// 4. Method References (::)
// Shorthand for calling a method.
class Q4 {
    void demo() {
        List<String> list = Arrays.asList("A", "B");
        list.forEach(System.out::println); // Method ref
    }
}

// 5. Default Methods in Interfaces
// Add new methods to interfaces without breaking existing implementations.
interface MyInterface {
    default void log() { System.out.println("Default Log"); }
}

// 6. Optional Class (Null Safety)
// Prevents NullPointerException by providing a wrapper.
class Q6 {
    void demo() {
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("Default"));
    }
}

// 7. Map vs FlatMap
// Map: Transforms each item. FlatMap: Transforms and Flattens (List of Lists).
class Q7 {
    void demo() {
        Stream.of(1, 2).map(n -> n * 2);
    }
}

// 8. Collectors (Collecting results)
// Convert a stream result back into a List or Set.
class Q8 {
    void demo() {
        List<Integer> list = Stream.of(1, 2).collect(Collectors.toList());
    }
}

// 9. Static Methods in Interfaces
// Utility methods that belong to the interface class itself.
interface Util {
    static void help() { System.out.println("Helping..."); }
}

// 10. StringJoiner
// Easy way to join strings with delimiters.
class Q10 {
    void demo() {
        StringJoiner sj = new StringJoiner(",");
        sj.add("A").add("B"); // A,B
    }
}

public class QUESTIONS {
    public static void main(String[] args) {
        System.out.println("10 Java 8 Questions with Code Ready.");
    }
}
