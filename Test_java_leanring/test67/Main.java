package Test_java_leanring.test67;

import java.util.stream.Stream;

/** test67 - Stream.of */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test67: Stream.of ===");
        Stream.of(1, 2, 3).forEach(System.out::println);
    }
}
