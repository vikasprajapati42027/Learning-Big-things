package java_version.Java8_version.lambda.test40;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Group students by department, then sort each group by marks descending.
 * A: groupingBy + downstream sorted list
 */
public class Main {
    public static void main(String[] args) {
        var students = DataProvider.getStudents();

        var byDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().sorted(Comparator.comparing(Student::getMarks).reversed()).collect(Collectors.toList()))));
        System.out.println("40. By department, sorted by marks: " + byDept);
    }
}
