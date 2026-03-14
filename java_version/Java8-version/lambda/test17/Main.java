package java_version.Java8_version.lambda.test17;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** test17: peek – debug without changing stream */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test17: Peek ===\n");
        List<Integer> list = Stream.of(1, 2, 3)
                .peek(n -> System.out.println("peek: " + n))
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("result: " + list);
    }
}
