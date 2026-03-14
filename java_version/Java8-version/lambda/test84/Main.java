package java_version.Java8_version.lambda.test84;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Sum of marks per department (aggregation).
 * A: groupingBy(Student::getDepartment, Collectors.summingInt(Student::getMarks)).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Integer> sumByDept = data.getStudentList().stream()
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.summingInt(Student::getMarks)));
        System.out.println("84. Sum marks by dept: " + sumByDept);
    }
}
