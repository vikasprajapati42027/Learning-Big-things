package Test_java_leanring.test71;

import java.util.List;
import java.util.stream.Collectors;

/** test71 - distinct, sorted */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test71: distinct sorted ===");
        List<Integer> out = List.of(3, 1, 2, 1).stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(out);
    }
}
