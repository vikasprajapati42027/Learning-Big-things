package Test_java_leanring.test2;

import Test_java_leanring.test1.Student;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test2: Inheritance ===");

        Student s = new Student("Alice", 1);
        GraduateStudent g = new GraduateStudent("Bob", 2, "Machine Learning");

        s.introduce();
        g.introduce();

        // Polymorphism: treat GraduateStudent as Student
        Student ref = new GraduateStudent("Charlie", 3, "Data Structures");
        ref.introduce();
    }
}
