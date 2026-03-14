package Test_java_leanring.test148;

import java.util.List;
import java.util.Set;

/** test148 - List.copyOf, Set.copyOf (Java 10) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test148: copyOf ===");
        List<String> list = List.copyOf(List.of("x", "y"));
        Set<Integer> set = Set.copyOf(Set.of(1, 2));
        System.out.println(list + " " + set);
    }
}
