import java.io.Serializable;

// The Data Transfer Object (Should be simple and serializable)
public class UserDTO implements Serializable {
    private String name;
    private String email;

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}
