package Test_java_leanring.test25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test25: Comparable ===");
        List<Student> list = new ArrayList<>(List.of(new Student("B", 2), new Student("A", 1)));
        Collections.sort(list);
        System.out.println(list.get(0).name);
    }
}
