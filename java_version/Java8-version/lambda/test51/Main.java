package java_version.Java8_version.lambda.test51;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Given a list of Student from model (getter/setter), how do you filter students with grade "A"?
 * A: Get list via getStudentList(), then stream().filter(s -> "A".equals(s.getGrade())).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Student> all = data.getStudentList();

        List<Student> gradeA = all.stream()
                .filter(s -> "A".equals(s.getGrade()))
                .collect(Collectors.toList());
        System.out.println("51. Filter grade A: " + gradeA);
    }
}
