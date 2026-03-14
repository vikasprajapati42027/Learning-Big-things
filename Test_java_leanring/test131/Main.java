package Test_java_leanring.test131;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

/** test131 - Stream toMap */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test131: toMap ===");
        Map<String, Integer> map = List.of("a", "bb", "c").stream()
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);
    }
}
