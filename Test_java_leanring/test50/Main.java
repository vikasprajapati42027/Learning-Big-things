package Test_java_leanring.test50;

import java.util.List;

/** test50 - Recap: Stream + Optional + Lambda */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test50: Recap (Stream, Optional, Lambda) ===");
        List<Integer> list = List.of(10, 20, 30);
        list.stream().map(x -> x + 1).forEach(System.out::println);
        System.out.println(list.stream().reduce(0, Integer::sum));
    }
}
