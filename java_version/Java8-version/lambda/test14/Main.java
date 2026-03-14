package java_version.Java8_version.lambda.test14;

import java.util.*;
import java.util.stream.Collectors;

/** test14: reducing – Collectors.reducing */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test14: Reducing ===\n");
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Optional<Integer> sum = list.stream().collect(Collectors.reducing(Integer::sum));
        System.out.println("reducing sum: " + sum.orElse(0));
        Integer product = list.stream().collect(Collectors.reducing(1, (a, b) -> a * b));
        System.out.println("reducing product: " + product);
    }
}
