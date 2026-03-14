package Test_java_leanring.test29;

import java.util.Iterator;
import java.util.List;

/** test29 - Iterator */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test29: Iterator ===");
        Iterator<String> it = List.of("X", "Y", "Z").iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}
