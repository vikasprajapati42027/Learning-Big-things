package Test_java_leanring.test8;

import Test_java_leanring.test1.Student;
import java.util.ArrayList;
import java.util.List;

/**
 * test8 - Collections: ArrayList to hold multiple objects.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test8: ArrayList ===");

        List<Student> list = new ArrayList<>();
        list.add(new Student("Alice", 1));
        list.add(new Student("Bob", 2));
        list.add(new Student("Charlie", 3));

        for (Student s : list) {
            s.introduce();
        }
        System.out.println("Size: " + list.size());
    }
}
