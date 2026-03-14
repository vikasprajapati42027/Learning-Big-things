package Java8_version;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/** Java 8 - Lambda expressions. */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java 8 Lambda Examples ===\n");

        Runnable r = () -> System.out.println("1. Runnable: Hello from lambda");
        r.run();

        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("2. Comparator: " + names);

        Consumer<String> print = s -> System.out.println("3. Consumer: " + s);
        print.accept("lambda");

        Function<String, Integer> length = s -> s.length();
        System.out.println("4. Function length: " + length.apply("hello"));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("5. Predicate isEven(4): " + isEven.test(4));

        Supplier<Double> random = () -> Math.random();
        System.out.println("6. Supplier: " + random.get());

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("7. BiFunction add: " + add.apply(10, 20));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("8. Stream: " + evens);

        names.forEach(System.out::println);
    }
}
