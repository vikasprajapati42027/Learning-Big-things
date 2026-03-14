package java_version.Java8_version.lambda.test42;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: What is the average salary in each department?
 * A: groupingBy + averagingDouble(Employee::getSalary)
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<String, Double> avgByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("42. Average salary by department: " + avgByDept);
    }
}
