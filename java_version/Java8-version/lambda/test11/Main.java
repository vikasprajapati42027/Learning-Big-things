package java_version.Java8_version.lambda.test11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** test11: Parallel stream – parallel(), sequential() */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test11: Parallel Stream ===\n");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sumParallel = list.parallelStream().mapToInt(i -> i).sum();
        System.out.println("parallelStream sum: " + sumParallel);
        int sumFromParallel = list.stream().parallel().mapToInt(i -> i).sum();
        System.out.println("stream().parallel() sum: " + sumFromParallel);
    }
}
