package Test_java_leanring.test147;

import java.util.List;
import java.util.Collections;

/** test147 - Collections.unmodifiableList */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test147: unmodifiableList ===");
        List<String> list = Collections.unmodifiableList(new java.util.ArrayList<>(List.of("a", "b")));
        System.out.println(list);
    }
}
