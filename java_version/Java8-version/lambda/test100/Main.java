package java_version.Java8_version.lambda.test100;

import java_version.Java8_version.lambda.model.Employee;
import java_version.Java8_version.lambda.model.ModelData;
import java_version.Java8_version.lambda.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Recap: Filter, aggregation, modification using model (getter/setter) and list data.
 * Q1: Filter students grade A, get names, join with comma.
 * Q2: Total and average salary from employee list.
 * Q3: Replace model's employee list with only IT employees (modification).
 */
public class Main {
    public static void main(String[] args) {
        ModelData data = new ModelData();

        String names = data.getStudentList().stream()
                .filter(s -> "A".equals(s.getGrade()))
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println("100. Grade A names: " + names);

        double total = data.getEmployeeList().stream().mapToDouble(Employee::getSalary).sum();
        double avg = data.getEmployeeList().stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println("   Total salary: " + total + ", Avg: " + avg);

        List<Employee> itOnly = data.getEmployeeList().stream()
                .filter(e -> "IT".equals(e.getDepartment()))
                .collect(Collectors.toList());
        data.setEmployeeList(itOnly);
        System.out.println("   Model after filter IT only: " + data.getEmployeeList());
    }
}
