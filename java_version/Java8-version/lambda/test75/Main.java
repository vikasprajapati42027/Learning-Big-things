package java_version.Java8_version.lambda.test75;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Filter students in department "CS", then sort by name.
 * A: filter(s -> "CS".equals(s.getDepartment())).sorted(Comparator.comparing(Student::getName)).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> cs = data.getStudentList().stream()
                .filter(s -> "CS".equals(s.getDepartment()))
                .sorted(java.util.Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        System.out.println("75. CS students by name: " + cs);
    }
}
