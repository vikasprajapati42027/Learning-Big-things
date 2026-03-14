package java_version.Java8_version.lambda.test8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;

/** test8: Primitive streams – IntStream, LongStream, DoubleStream */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test8: Primitive Streams ===\n");
        System.out.println("IntStream.range(1,5).sum(): " + IntStream.range(1, 5).sum());
        System.out.println("IntStream.rangeClosed(1,5).sum(): " + IntStream.rangeClosed(1, 5).sum());
        System.out.println("DoubleStream.of(1,2,3).average(): " + DoubleStream.of(1, 2, 3).average().orElse(0));
        System.out.println("IntStream boxed to list: " + IntStream.range(1, 4).boxed().collect(Collectors.toList()));
    }
}
