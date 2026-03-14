package java_version.Java8_version.lambda.test46;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Create a map of employee name to salary. How do you handle duplicate keys?
 * A: toMap(Employee::getName, Employee::getSalary). For duplicates use merge: (v1,v2)->v1 or (v1,v2)->v2
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<String, Double> nameToSalary = employees.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary, (existing, replacement) -> existing));
        System.out.println("46. Name to salary: " + nameToSalary);
    }
}
