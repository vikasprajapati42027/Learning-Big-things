package Test_java_leanring.test70;

import java.util.List;
import java.util.stream.Collectors;

/** test70 - flatMap */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test70: flatMap ===");
        List<List<Integer>> nested = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> flat = nested.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flat);
    }
}
