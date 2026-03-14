package java_version.Java8_version.lambda.test54;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.stream.Collectors;

/**
 * Q: Aggregation – what is the sum of marks of all students in the list?
 * A: getStudentList().stream().mapToInt(Student::getMarks).sum()
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        int totalMarks = data.getStudentList().stream()
                .mapToInt(Student::getMarks)
                .sum();
        System.out.println("54. Sum of marks: " + totalMarks);
    }
}
