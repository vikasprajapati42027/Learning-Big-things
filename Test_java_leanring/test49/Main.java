package Test_java_leanring.test49;

import java.util.List;
import java.util.stream.Collectors;

/** test49 - Stream (filter, map) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test49: Stream ===");
        List<String> out = List.of(1, 2, 3, 4, 5).stream()
                .filter(x -> x % 2 == 0)
                .map(x -> "n" + x)
                .collect(Collectors.toList());
        System.out.println(out);
    }
}
