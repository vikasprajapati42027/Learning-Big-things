package Test_java_leanring.test33;

import java.util.Optional;

/** test33 - Optional */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test33: Optional ===");
        Optional<String> opt = Optional.of("hello");
        System.out.println(opt.get());
        System.out.println(Optional.empty().orElse("default"));
    }
}
