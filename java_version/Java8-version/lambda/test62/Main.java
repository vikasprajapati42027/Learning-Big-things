package java_version.Java8_version.lambda.test62;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Filter students with marks >= 80, then store result back in model (modification of list).
 * A: List<Student> filtered = stream().filter(...).collect(toList()); data.setStudentList(filtered);
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> filtered = data.getStudentList().stream()
                .filter(s -> s.getMarks() >= 80)
                .collect(Collectors.toList());
        data.setStudentList(filtered);
        System.out.println("62. Model list after filter (marks>=80): " + data.getStudentList());
    }
}
