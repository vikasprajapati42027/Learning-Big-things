package java_version.Java8_version.lambda.test56;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.OptionalDouble;

/**
 * Q: Aggregation – average marks of students in the model list.
 * A: getStudentList().stream().mapToInt(Student::getMarks).average() returns OptionalDouble.
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        OptionalDouble avg = data.getStudentList().stream()
                .mapToInt(Student::getMarks)
                .average();
        System.out.println("56. Average marks: " + (avg.isPresent() ? avg.getAsDouble() : 0));
    }
}
