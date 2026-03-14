package Test_java_leanring.test65;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/** test65 - Collections.sort, reverse */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test65: Collections ===");
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
