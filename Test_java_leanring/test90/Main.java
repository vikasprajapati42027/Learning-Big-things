package Test_java_leanring.test90;

import java.util.Collections;
import java.util.List;

/** test90 - Collections.binarySearch */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test90: binarySearch ===");
        List<Integer> list = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(Collections.binarySearch(list, 3));
    }
}
