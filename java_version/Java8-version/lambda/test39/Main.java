package java_version.Java8_version.lambda.test39;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Get distinct department names from the employee list.
 * A: map(Employee::getDepartment).distinct().collect(Collectors.toList())
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        List<String> depts = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("39. Distinct departments: " + depts);
    }
}
