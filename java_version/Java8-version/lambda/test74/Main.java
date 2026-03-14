package java_version.Java8_version.lambda.test74;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Create map: department -> list of employee names (not full object).
 * A: groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, java.util.List<String>> deptToNames = data.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("74. Dept -> names: " + deptToNames);
    }
}
