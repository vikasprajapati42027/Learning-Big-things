package java_version.Java8_version.lambda.test99;

import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Group students by department, then sort each group by marks descending (multi-level).
 * A: groupingBy with downstream: collectingAndThen(toList(), list -> list.stream().sorted(...).collect(toList())).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, List<Student>> byDept = data.getStudentList().stream()
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream().sorted(java.util.Comparator.comparing(Student::getMarks).reversed()).collect(Collectors.toList()))));
        System.out.println("99. By dept, sorted by marks: " + byDept);
    }
}
