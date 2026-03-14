package java_version.Java8_version.lambda.test47;

import java_version.Java8_version.lambda.data.DataProvider;
import java_version.Java8_version.lambda.data.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q: Group employees by department, then within each department group by salary range (e.g. <60k, >=60k).
 * A: groupingBy(Department), then groupingBy(salary >= 60000) as downstream
 */
public class Main {
    public static void main(String[] args) {
        var employees = DataProvider.getEmployees();

        Map<String, Map<Boolean, List<Employee>>> nested = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.partitioningBy(e -> e.getSalary() >= 60000)));
        System.out.println("47. By department then salary range (>=60k): " + nested);
    }
}
