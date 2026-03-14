package java_version.Java8_version.lambda.test88;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Get students with marks between 70 and 90 (inclusive). Filter range.
 * A: filter(s -> s.getMarks() >= 70 && s.getMarks() <= 90).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> result = data.getStudentList().stream()
                .filter(s -> s.getMarks() >= 70 && s.getMarks() <= 90)
                .collect(Collectors.toList());
        System.out.println("88. Marks 70-90: " + result);
    }
}
