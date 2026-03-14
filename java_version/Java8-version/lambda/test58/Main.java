package java_version.Java8_version.lambda.test58;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Group students by department (aggregation – list per key).
 * A: stream().collect(Collectors.groupingBy(Student::getDepartment)).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, java.util.List<Student>> byDept = data.getStudentList().stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println("58. Students by department: " + byDept.keySet());
    }
}
