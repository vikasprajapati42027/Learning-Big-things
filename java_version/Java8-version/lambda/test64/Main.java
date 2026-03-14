package java_version.Java8_version.lambda.test64;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Get only names (String list) of students from model list.
 * A: getStudentList().stream().map(Student::getName).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<String> names = data.getStudentList().stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("64. Student names: " + names);
    }
}
