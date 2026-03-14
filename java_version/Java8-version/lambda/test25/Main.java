package java_version.Java8_version.lambda.test25;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** test25: Recap – mixed advanced (partitioning, iterate, reduce, teeing-style) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test25: Recap Advanced ===\n");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> oddEven = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("partitioningBy: " + oddEven);
        int sumSquares = list.stream().mapToInt(n -> n * n).sum();
        System.out.println("sum of squares: " + sumSquares);
        Optional<Integer> product = list.stream().reduce((a, b) -> a * b);
        System.out.println("reduce product: " + product.orElse(0));
        List<Integer> fib = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(10).map(f -> f[0]).collect(Collectors.toList());
        System.out.println("Fibonacci 10: " + fib);
        System.out.println("Done.");
    }
}
