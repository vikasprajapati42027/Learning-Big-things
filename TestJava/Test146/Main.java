package TestJava.Test146;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Employee(String name, String department, double salary) {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Advanced Stream Grouping & Teeing (Java 12+) ===\n");

        List<Employee> employees = List.of(
            new Employee("Alice", "Engineering", 120000),
            new Employee("Bob", "Engineering", 90000),
            new Employee("Charlie", "HR", 60000),
            new Employee("Diana", "HR", 75000),
            new Employee("Eve", "Sales", 85000)
        );

        System.out.println("--- 1. Advanced Grouping (groupingBy + mapping) ---");
        // We want a Map showing Department -> List of Names (not the whole Employee object!)
        Map<String, List<String>> namesByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::department,
                Collectors.mapping(Employee::name, Collectors.toList())
            ));
            
        namesByDept.forEach((dept, names) -> 
            System.out.println(dept + ": " + names));

        System.out.println("\n--- 2. Collectors.teeing (Java 12+) ---");
        System.out.println("Teeing allows you to pass the stream into TWO separate collectors,");
        System.out.println("and then merge their results!\n");

        // Goal: Find the Highest Paid Employee AND the Lowest Paid Employee in one pass!
        // We define a simple record to hold the result
        record SalaryExtremes(Employee min, Employee max) {}

        SalaryExtremes extremes = employees.stream()
            .collect(Collectors.teeing(
                // Collector 1: Find Min Salary
                Collectors.minBy((e1, e2) -> Double.compare(e1.salary(), e2.salary())),
                // Collector 2: Find Max Salary
                Collectors.maxBy((e1, e2) -> Double.compare(e1.salary(), e2.salary())),
                // Merger function: Combine the results!
                (min, max) -> new SalaryExtremes(min.orElse(null), max.orElse(null))
            ));
            
        System.out.println("Lowest Paid : " + extremes.min().name() + " ($" + extremes.min().salary() + ")");
        System.out.println("Highest Paid: " + extremes.max().name() + " ($" + extremes.max().salary() + ")");
    }
}
