package java_version.Java8_version.lambda.test86;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.Optional;

/**
 * Q: Find any student with marks 95. Difference between findFirst and findAny?
 * A: filter(s -> s.getMarks()==95).findAny(). findFirst=first in order; findAny=any (matters in parallel).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Optional<Student> any = data.getStudentList().stream()
                .filter(s -> s.getMarks() == 95)
                .findAny();
        System.out.println("86. Any student with 95: " + any.map(Student::toString).orElse("none"));
    }
}
