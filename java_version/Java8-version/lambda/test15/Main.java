package java_version.Java8_version.lambda.test15;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/** test15: groupingBy with downstream – counting, mapping, toSet */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test15: GroupingBy downstream ===\n");
        List<String> list = Arrays.asList("a", "ab", "abc", "b", "bc");
        Map<Integer, Long> countByLen = list.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("group by length, count: " + countByLen);
        Map<Integer, Set<String>> setByLen = list.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("group by length, toSet: " + setByLen);
    }
}
