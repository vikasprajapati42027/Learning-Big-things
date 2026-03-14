package java_version.Java8_version.lambda.test1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java 8 - Lambda & Stream: Interview Q&A with code
 * Run from project root: javac java_version/Java8-version/lambda/test1/Main.java
 *                        java -cp . java_version.Java8_version.lambda.test1.Main
 */
public class Main {

    public static void main(String[] args) {

        // ========== Q1: What is a Lambda in Java 8? ==========
        // Answer: A lambda is a short way to write an anonymous function (one method).
        // Instead of: new Runnable() { public void run() { System.out.println("hi"); } }
        // You write:  () -> System.out.println("hi")

        Runnable r = () -> System.out.println("Lambda: hi");
        r.run();

        // ========== Q2: How do you convert a Stream to a List? ==========
        // Answer: Use stream.collect(Collectors.toList()). It gathers all stream elements into a List.

        Stream<String> stream = Stream.of("apple", "banana", "cherry");
        List<String> collected = stream.collect(Collectors.toList());
        System.out.println("Collected list: " + collected);

        // ========== Q3: What does (x) -> x * 2 mean? ==========
        // Answer: It's a lambda that takes one argument x and returns x * 2.
        // Same idea as a function: f(x) = x * 2.

        List<Integer> numbers = Stream.of(1, 2, 3)
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled: " + numbers);

        // ========== Q4: How do you filter a Stream with a condition? ==========
        // Answer: Use .filter(condition). Only elements that make the condition true are kept.

        List<Integer> evens = Stream.of(1, 2, 3, 4, 5)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Evens: " + evens);

        // ========== Q5: What is Collectors.toList()? ==========
        // Answer: It's a Collector that collects stream elements into a new ArrayList.
        // collect(Collectors.toList()) = "give me all items from the stream in a List".

        Stream<String> stream2 = Stream.of("one", "two", "three");
        List<String> asList = stream2.collect(Collectors.toList());
        System.out.println("As list: " + asList);
    }
}
