package java_version.Java8_version.lambda.test13;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** test13: Nested structures – flatMap with lists/objects */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test13: FlatMap ===\n");
        List<List<Integer>> nested = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
        List<Integer> flat = nested.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("flatMap lists: " + flat);
        List<String> lines = Arrays.asList("a b", "c d");
        List<String> words = lines.stream().flatMap(line -> Arrays.stream(line.split(" "))).collect(Collectors.toList());
        System.out.println("flatMap split: " + words);
    }
}
