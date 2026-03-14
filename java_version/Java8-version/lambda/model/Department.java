package java_version.Java8_version.lambda.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Department model – getter/setter and list of employees (for real interview style).
 */
public class Department {
    private int id;
    private String name;
    private String location;
    private List<Employee> employees = new ArrayList<>();

    public Department(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    @Override
    public String toString() { return name + "(" + location + ")"; }
}
