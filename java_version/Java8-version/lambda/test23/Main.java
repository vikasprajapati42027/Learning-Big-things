package java_version.Java8_version.lambda.test23;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** test23: Stream concat, distinct, sorted combinations */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test23: Concat distinct sorted ===\n");
        Stream<Integer> s1 = Stream.of(3, 1, 2);
        Stream<Integer> s2 = Stream.of(2, 3, 4);
        List<Integer> merged = Stream.concat(s1, s2).distinct().sorted().collect(Collectors.toList());
        System.out.println("concat distinct sorted: " + merged);
        List<String> a = Arrays.asList("c", "a", "b");
        List<String> b = Arrays.asList("b", "d", "a");
        List<String> union = Stream.concat(a.stream(), b.stream()).distinct().sorted().collect(Collectors.toList());
        System.out.println("union sorted: " + union);
    }
}
