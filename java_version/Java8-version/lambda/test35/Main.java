package java_version.Java8_version.lambda.test35;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: What is the total salary paid by each department?
 * A: groupingBy + summingDouble(Employee::getSalary)
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<String, Double> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));
        System.out.println("35. Total salary by department: " + totalByDept);
    }
}
