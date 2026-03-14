package java_version.Java8_version.lambda.test59;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Modification – give 10% increment to all employees and collect into a new list (new objects).
 * A: map to new Employee with getSalary()*1.1, or use peek to modify in place (same list).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Employee> incremented = data.getEmployeeList().stream()
                .map(e -> {
                    Employee copy = new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary() * 1.1, e.getAge());
                    return copy;
                })
                .collect(Collectors.toList());
        System.out.println("59. After 10% increment (new list): " + incremented);
    }
}
