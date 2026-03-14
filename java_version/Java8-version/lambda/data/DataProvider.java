package java_version.Java8_version.lambda.data;

import java.util.Arrays;
import java.util.List;

/** Sample Student, Employee, Department data for Java 8 interview examples */
public class DataProvider {

    public static List<Student> getStudents() {
        return Arrays.asList(
                new Student(1, "Alice", "A", 92, "CS"),
                new Student(2, "Bob", "B", 75, "CS"),
                new Student(3, "Charlie", "A", 88, "EC"),
                new Student(4, "Diana", "C", 62, "CS"),
                new Student(5, "Eve", "A", 95, "EC"),
                new Student(6, "Frank", "B", 71, "ME")
        );
    }

    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(1, "John", "IT", 60000, 28),
                new Employee(2, "Jane", "HR", 55000, 32),
                new Employee(3, "Mike", "IT", 75000, 35),
                new Employee(4, "Sarah", "HR", 52000, 27),
                new Employee(5, "Tom", "Finance", 80000, 40),
                new Employee(6, "Lisa", "IT", 65000, 30),
                new Employee(7, "David", "Finance", 72000, 38)
        );
    }

    public static List<Department> getDepartments() {
        return Arrays.asList(
                new Department(1, "IT", "Building-A"),
                new Department(2, "HR", "Building-B"),
                new Department(3, "Finance", "Building-A")
        );
    }
}
