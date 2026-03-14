package java_version.Java8_version.lambda.test83;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Filter employees age > 30 and salary > 55000 (multiple conditions).
 * A: filter(e -> e.getAge() > 30 && e.getSalary() > 55000).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Employee> result = data.getEmployeeList().stream()
                .filter(e -> e.getAge() > 30 && e.getSalary() > 55000)
                .collect(Collectors.toList());
        System.out.println("83. Age>30 and salary>55k: " + result);
    }
}
