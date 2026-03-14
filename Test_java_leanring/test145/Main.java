package Test_java_leanring.test145;

import java.util.Objects;

/** test145 - Objects.equals, hash */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test145: Objects ===");
        System.out.println(Objects.equals("a", "a"));
        System.out.println(Objects.hash(1, "x"));
    }
}
