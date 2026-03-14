package java_version.Java8_version.lambda.test92;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.Comparator;
import java.util.Optional;

/** Q: Student with minimum marks. A: min(Comparator.comparing(Student::getMarks)). */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Optional<Student> min = data.getStudentList().stream()
                .min(Comparator.comparing(Student::getMarks));
        System.out.println("92. Min marks: " + min.map(Student::toString).orElse("none"));
    }
}
