package java_version.Java8_version.lambda.test79;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Map employee name to salary (key-value from list).
 * A: collect(Collectors.toMap(Employee::getName, Employee::getSalary, (a,b)->a)).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Map<String, Double> nameToSal = data.getEmployeeList().stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary, (a, b) -> a));
        System.out.println("79. Name -> salary: " + nameToSal);
    }
}
