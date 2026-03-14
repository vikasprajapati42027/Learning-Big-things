package Test_java_leanring.test47;

import java.util.List;

/** test47 - Wildcards */
public class Main {
    static void print(List<?> list) {
        for (Object o : list) System.out.println(o);
    }
    public static void main(String[] args) {
        System.out.println("=== test47: Wildcards ===");
        print(List.of(1, 2, 3));
        print(List.of("a", "b"));
    }
}
