package java_version.Java8_version.lambda.test78;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Modification – set grade to "A" for all students with marks >= 90. New list.
 * A: map(s -> { if (s.getMarks()>=90) return new Student(..., "A", ...); return s; }).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> updated = data.getStudentList().stream()
                .map(s -> {
                    if (s.getMarks() >= 90)
                        return new Student(s.getId(), s.getName(), "A", s.getMarks(), s.getDepartment());
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println("78. Marks>=90 -> grade A: " + updated);
    }
}
