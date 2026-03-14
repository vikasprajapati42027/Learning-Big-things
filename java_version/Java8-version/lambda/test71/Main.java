package java_version.Java8_version.lambda.test71;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Filter + modification – add 10 marks only to students with grade "C", others unchanged. New list.
 * A: map(s -> "C".equals(s.getGrade()) ? new Student(..., s.getMarks()+10, ...) : s).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> result = data.getStudentList().stream()
                .map(s -> {
                    if ("C".equals(s.getGrade()))
                        return new Student(s.getId(), s.getName(), s.getGrade(), s.getMarks() + 10, s.getDepartment());
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println("71. Grade C +10 bonus: " + result);
    }
}
