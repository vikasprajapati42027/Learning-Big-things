package Test6;

/**
 * A simple DTO (Data Transfer Object) class.
 * Spring will automatically convert instances of this class to JSON 
 * because of the Jackson library on the classpath.
 */
public class UserResponse {

    private String name;
    private String role;

    public UserResponse(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Getters are required for JSON serialization
    public String getName() { return name; }
    public String getRole() { return role; }
}
