package java_version.Java8_version.lambda.test69;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Aggregation – count students per grade (A, B, C).
 * A: groupingBy(Student::getGrade, Collectors.counting()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Long> byGrade = data.getStudentList().stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        System.out.println("69. Count by grade: " + byGrade);
    }
}
