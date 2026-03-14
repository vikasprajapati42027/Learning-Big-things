package Test_java_leanring.test130;

import java.util.List;
import java.util.stream.Stream;

/** test130 - Stream peek */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test130: Stream peek ===");
        List<Integer> list = Stream.of(1, 2, 3).peek(System.out::println).toList();
        System.out.println(list);
    }
}
