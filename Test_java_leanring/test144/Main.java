package Test_java_leanring.test144;

import java.util.Objects;

/** test144 - Objects.requireNonNull */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test144: requireNonNull ===");
        String s = Objects.requireNonNull("ok");
        System.out.println(s);
    }
}
