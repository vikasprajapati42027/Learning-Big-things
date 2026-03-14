package java_version.Java8_version.lambda.test6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** test6: Collectors – toSet, toMap with merge, toCollection */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test6: Collectors ===\n");
        List<String> list = Arrays.asList("a", "b", "a", "c");
        Set<String> set = list.stream().collect(Collectors.toSet());
        System.out.println("toSet: " + set);
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
        System.out.println("toMap with merge: " + map);
        LinkedList<String> linked = list.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("toCollection LinkedList: " + linked);
    }
}
