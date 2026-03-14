package java_version.Java8_version.lambda.test33;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Count number of employees in each department.
 * A: groupingBy(Employee::getDepartment, Collectors.counting())
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("33. Employee count by department: " + countByDept);
    }
}
