package Test_java_leanring.test132;

import java.util.Optional;
import java.util.List;

/** test132 - Optional orElseThrow */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test132: orElseThrow ===");
        String s = Optional.<String>empty().orElse("default");
        System.out.println(s);
    }
}
