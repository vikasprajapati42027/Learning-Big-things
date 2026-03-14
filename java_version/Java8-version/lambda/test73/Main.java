package java_version.Java8_version.lambda.test73;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.stream.Collectors;

/**
 * Q: Join all student names with comma from model list.
 * A: getStudentList().stream().map(Student::getName).collect(Collectors.joining(", ")).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        String joined = data.getStudentList().stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println("73. Joined names: " + joined);
    }
}
