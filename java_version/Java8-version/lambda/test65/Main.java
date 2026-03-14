package java_version.Java8_version.lambda.test65;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Average salary per department (aggregation).
 * A: groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Double> avg = data.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("65. Average salary by dept: " + avg);
    }
}
