package java_version.Java8_version.lambda.test90;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.Map;
import java.util.stream.Collectors;

/** Q: Average marks per department. A: groupingBy(Student::getDepartment, averagingDouble(Student::getMarks)). */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Double> avgByDept = data.getStudentList().stream()
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.averagingDouble(Student::getMarks)));
        System.out.println("90. Avg marks by dept: " + avgByDept);
    }
}
