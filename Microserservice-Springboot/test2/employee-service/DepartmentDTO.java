package test2.employee;

/**
 * DTO to map the response from Department Microservice.
 */
public class DepartmentDTO {
    private Long id;
    private String name;
    private String location;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
