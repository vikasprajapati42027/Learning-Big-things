package java_version.Java8_version.lambda.test95;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Skip first 2 students and get rest (pagination-style).
 * A: stream().skip(2).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> rest = data.getStudentList().stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("95. Skip 2: " + rest);
    }
}
