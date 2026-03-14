package java_version.Java8_version.lambda.test27;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Write a Java 8 program to get all students with grade "A".
 * Q: Sort students by name.
 */
public class Main {
    public static void main(String[] args) {
        var students = DataProvider.getStudents();

        List<Student> gradeA = students.stream()
                .filter(s -> "A".equals(s.getGrade()))
                .collect(Collectors.toList());
        System.out.println("27. Students with grade A: " + gradeA);

        List<Student> byName = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        System.out.println("   Sorted by name: " + byName);
    }
}
