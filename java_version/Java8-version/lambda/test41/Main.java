package java_version.Java8_version.lambda.test41;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Get list of students with marks > 85. Return only their names.
 * A: filter + map(Student::getName) + collect
 */
public class Main {
    public static void main(String[] args) {
        var students = DataProvider.getStudents();

        List<String> names = students.stream()
                .filter(s -> s.getMarks() > 85)
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("41. Names with marks > 85: " + names);
    }
}
