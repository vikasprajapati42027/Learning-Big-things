package java_version.Java8_version.lambda.test22;

import java.util.*;
import java.util.stream.Collectors;

/** test22: Multi-level groupingBy */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test22: Multi-level groupingBy ===\n");
        List<String> list = Arrays.asList("apple", "ape", "banana", "ball");
        Map<Integer, Map<Character, List<String>>> byLenThenFirst = list.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(s -> s.charAt(0))));
        System.out.println("group by length then first char: " + byLenThenFirst);
    }
}
