package Test_java_leanring.test30;

import java.util.List;

/** test30 - for-each */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test30: for-each ===");
        for (String s : List.of("p", "q", "r")) System.out.println(s);
    }
}
