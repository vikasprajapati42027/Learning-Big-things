package java_version.Java8_version.lambda.test16;

import java.util.*;
import java.util.stream.Collectors;

/** test16: toMap with duplicate keys – merge function */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test16: toMap merge ===\n");
        List<String> list = Arrays.asList("a", "b", "a", "c", "b");
        Map<String, Integer> withMerge = list.stream().collect(Collectors.toMap(s -> s, s -> 1, (old, n) -> old + n));
        System.out.println("toMap (key, 1, merge sum): " + withMerge);
        Map<String, String> firstWins = list.stream().collect(Collectors.toMap(s -> s, s -> s, (first, second) -> first));
        System.out.println("toMap first wins: " + firstWins);
    }
}
