package java_version.Java8_version.lambda.test24;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** test24: Functional interfaces – Predicate, Function, Supplier in streams */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test24: Functional in Streams ===\n");
        java.util.function.Predicate<Integer> even = n -> n % 2 == 0;
        List<Integer> evens = Arrays.asList(1, 2, 3, 4).stream().filter(even).collect(Collectors.toList());
        System.out.println("Predicate even: " + evens);
        Function<String, Integer> len = String::length;
        List<Integer> lengths = Stream.of("a", "ab", "abc").map(len).collect(Collectors.toList());
        System.out.println("Function length: " + lengths);
        java.util.function.Supplier<Double> random = Math::random;
        System.out.println("Supplier random: " + random.get());
    }
}
