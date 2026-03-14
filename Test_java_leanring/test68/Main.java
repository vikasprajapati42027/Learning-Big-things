package Test_java_leanring.test68;

import java.util.List;

/** test68 - Stream reduce */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test68: Stream reduce ===");
        int sum = List.of(1, 2, 3).stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
