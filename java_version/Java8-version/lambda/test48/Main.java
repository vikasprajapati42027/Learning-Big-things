package java_version.Java8_version.lambda.test48;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Get top 3 highest-paid employees from the list.
 * A: sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3)
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        List<Employee> top3 = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("48. Top 3 by salary: " + top3);
    }
}
