package java_version.Java8_version.lambda.test21;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** test21: Empty stream, Optional from stream */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test21: Empty & Optional ===\n");
        Stream<String> empty = Stream.empty();
        List<String> list = empty.collect(Collectors.toList());
        System.out.println("Stream.empty() collect: " + list);
        Optional<String> first = Stream.<String>empty().findFirst();
        System.out.println("empty findFirst: " + first.orElse("none"));
        Optional<Integer> maxEmpty = Arrays.asList(1, 2, 3).stream().filter(n -> n > 10).max(Integer::compareTo);
        System.out.println("max of filtered empty: " + maxEmpty.orElse(-1));
    }
}
