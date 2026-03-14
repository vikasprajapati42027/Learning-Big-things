package java_version.Java8_version.lambda.test97;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.stream.Collectors;

/**
 * Q: Check if any student has marks >= 95 (anyMatch).
 * A: stream().anyMatch(s -> s.getMarks() >= 95).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        boolean any = data.getStudentList().stream().anyMatch(s -> s.getMarks() >= 95);
        System.out.println("97. Any marks >= 95: " + any);
    }
}
