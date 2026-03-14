package Test_java_leanring.test72;

import java.util.List;

/** test72 - limit, skip */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test72: limit skip ===");
        List.of(1, 2, 3, 4, 5).stream().skip(1).limit(2).forEach(System.out::println);
    }
}
