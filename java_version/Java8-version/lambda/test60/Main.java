package java_version.Java8_version.lambda.test60;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Modification – add 5 bonus marks to all students (create new list with setter/getter).
 * A: map: new Student(..., s.getMarks()+5) or get list, forEach(s -> s.setMarks(s.getMarks()+5)).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> withBonus = data.getStudentList().stream()
                .map(s -> {
                    Student n = new Student(s.getId(), s.getName(), s.getGrade(), s.getMarks() + 5, s.getDepartment());
                    return n;
                })
                .collect(Collectors.toList());
        System.out.println("60. Students with +5 bonus: " + withBonus);
    }
}
