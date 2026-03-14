package java_version.Java8_version.lambda.test87;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Q: Min salary per department (aggregation).
 * A: groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparing(Employee::getSalary))).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Optional<Employee>> minByDept = data.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.minBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("87. Min salary per dept: " + minByDept.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue().map(Employee::getSalary).orElse(0.0)).collect(java.util.stream.Collectors.joining(", ")));
    }
}
