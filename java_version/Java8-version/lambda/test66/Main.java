package java_version.Java8_version.lambda.test66;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Sort student list by marks descending and update model with sorted list.
 * A: sorted(Comparator.comparing(Student::getMarks).reversed()).collect(toList()); setStudentList(...).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> sorted = data.getStudentList().stream()
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .collect(Collectors.toList());
        data.setStudentList(sorted);
        System.out.println("66. Sorted by marks desc: " + data.getStudentList());
    }
}
