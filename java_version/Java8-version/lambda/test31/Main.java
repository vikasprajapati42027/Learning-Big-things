package java_version.Java8_version.lambda.test31;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Get students with marks >= 80, sorted by marks descending.
 * A: filter + sorted(Comparator.comparing(Student::getMarks).reversed())
 */
public class Main {
    public static void main(String[] args) {
        var students = DataProvider.getStudents();

        List<Student> result = students.stream()
                .filter(s -> s.getMarks() >= 80)
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .collect(Collectors.toList());
        System.out.println("31. Students marks>=80 (desc): " + result);
    }
}
