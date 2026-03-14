import java.util.*;

// Simple Employee Service
public class EmployeeService {
    public static void main(String[] args) {
        System.out.println("--- Employee Service Starting (Dockerized) ---");
        List<String> employees = Arrays.asList("Vikas", "John", "Alice");
        employees.forEach(emp -> System.out.println("Employee: " + emp));
    }
}
