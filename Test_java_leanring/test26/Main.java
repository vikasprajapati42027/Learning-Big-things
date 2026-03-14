package Test_java_leanring.test26;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** test26 - Comparator */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test26: Comparator ===");
        List<String> list = new ArrayList<>(List.of("C", "A", "B"));
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}
