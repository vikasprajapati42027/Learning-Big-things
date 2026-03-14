package java_version.Java8_version.lambda.test44;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Group students by grade (A, B, C). What collector do you use?
 * A: Collectors.groupingBy(Student::getGrade)
 */
public class Main {
    public static void main(String[] args) {
        var students = DataProvider.getStudents();

        Map<String, List<Student>> byGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("44. Students by grade: " + byGrade);
    }
}
