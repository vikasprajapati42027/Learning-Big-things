package Test_java_leanring.test69;

import java.util.List;
import java.util.Optional;

/** test69 - findFirst, findAny */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test69: findFirst ===");
        Optional<Integer> o = List.of(1, 2, 3).stream().filter(x -> x > 1).findFirst();
        System.out.println(o.get());
    }
}
