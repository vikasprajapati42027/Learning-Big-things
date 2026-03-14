package java_version.Java8_version.lambda.test85;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Q: Modification – increment salary by 5% only for HR department. New list.
 * A: map(e -> "HR".equals(e.getDepartment()) ? new Employee(..., e.getSalary()*1.05, ...) : e).collect(toList()).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();
        List<Employee> result = data.getEmployeeList().stream()
                .map(e -> {
                    if ("HR".equals(e.getDepartment()))
                        return new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary() * 1.05, e.getAge());
                    return e;
                })
                .collect(Collectors.toList());
        System.out.println("85. HR +5% salary: " + result);
    }
}
