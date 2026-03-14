package java_version.Java8_version.lambda.test82;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Remove duplicate departments from student list (distinct by department name).
 * A: We have list of Student; distinct by getDepartment(): use map then distinct, or groupingBy to get one per dept.
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<String> distinctDepts = data.getStudentList().stream()
                .map(Student::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("82. Distinct student departments: " + distinctDepts);
    }
}
