package Test_java_leanring.test83;

import java.util.Arrays;

/** test83 - String split */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test83: split ===");
        String[] parts = "a-b-c".split("-");
        System.out.println(Arrays.toString(parts));
    }
}
