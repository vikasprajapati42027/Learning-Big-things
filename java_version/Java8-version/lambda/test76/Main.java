package java_version.Java8_version.lambda.test76;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Comparator;
import java.util.Optional;

/**
 * Q: Highest-paid employee in IT department. Use getters.
 * A: filter(IT).max(Comparator.comparing(Employee::getSalary)).map(Employee::getName).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Optional<String> name = data.getEmployeeList().stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName);
        System.out.println("76. Highest in IT: " + name.orElse("none"));
    }
}
