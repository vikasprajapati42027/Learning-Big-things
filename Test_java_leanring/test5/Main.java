package Test_java_leanring.test5;

import Test_java_leanring.test1.Student;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test5: Composition ===");

        Course c = new Course("Java 101");
        c.addStudent(new Student("Alice", 1));
        c.addStudent(new Student("Bob", 2));
        c.listStudents();
    }
}
