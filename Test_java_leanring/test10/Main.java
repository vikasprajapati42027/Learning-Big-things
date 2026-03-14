package Test_java_leanring.test10;

import Test_java_leanring.test1.Student;
import Test_java_leanring.test2.GraduateStudent;
import Test_java_leanring.test4.Teacher;
import Test_java_leanring.test4.Person;
import Test_java_leanring.test7.Counter;

import java.util.ArrayList;
import java.util.List;

/**
 * test10 - Recap: concepts from test1 to test9 in one place.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test10: Recap (Class, Inheritance, Abstract, Static, List) ===");

        Student s = new Student("Alice", 1);
        GraduateStudent g = new GraduateStudent("Bob", 2, "AI");
        Person p = new Teacher("Mr. Smith", "Math");

        s.introduce();
        g.introduce();
        System.out.println(p.getName() + " - " + p.getRole());

        System.out.println("Static count: " + Counter.getCount());

        List<Student> list = new ArrayList<>();
        list.add(s);
        list.add(g);
        System.out.println("List size: " + list.size());
        System.out.println("Done.");
    }
}
