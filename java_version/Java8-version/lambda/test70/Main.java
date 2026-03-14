package java_version.Java8_version.lambda.test70;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Optional;

/**
 * Q: Find first employee in HR department. Handle empty with Optional.
 * A: filter(e -> "HR".equals(e.getDepartment())).findFirst().orElse(null).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Optional<Employee> firstHR = data.getEmployeeList().stream()
                .filter(e -> "HR".equals(e.getDepartment()))
                .findFirst();
        System.out.println("70. First HR: " + firstHR.map(Employee::toString).orElse("none"));
    }
}
