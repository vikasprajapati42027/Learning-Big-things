package Test_java_leanring.test5;

import Test_java_leanring.test1.Student;
import java.util.ArrayList;
import java.util.List;

/**
 * test5 - Composition: Course "has-a" list of Students.
 */
public class Course {
    private String name;
    private List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void listStudents() {
        System.out.println("Course: " + name);
        for (Student s : students) {
            s.introduce();
        }
    }
}
