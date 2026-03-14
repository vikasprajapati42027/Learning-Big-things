package java_version.Java8_version.lambda.test50;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;
import java_version.Java8_version.lambda.data.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Advanced recap: multiple data types, grouping, optional, sorting.
 * Q: Get the name of the highest-paid employee in "IT". If none, return "N/A".
 * Q: List student names from department "CS" sorted by marks descending.
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();
        var students = DataProvider.getStudents();

        String topIT = employees.stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName)
                .orElse("N/A");
        System.out.println("50. Highest-paid in IT: " + topIT);

        List<String> csByMarks = students.stream()
                .filter(s -> "CS".equals(s.getDepartment()))
                .sorted(Comparator.comparing(Student::getMarks).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("   CS students by marks desc: " + csByMarks);

        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("   Employee count by dept: " + countByDept);
    }
}
