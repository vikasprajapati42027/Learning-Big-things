package java_version.Java8_version.lambda.test81;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.Comparator;
import java.util.Optional;

/**
 * Q: Second highest salary from employee list. Real interview question.
 * A: sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        Optional<Employee> second = data.getEmployeeList().stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
        System.out.println("81. Second highest salary: " + second.map(Employee::toString).orElse("none"));
    }
}
