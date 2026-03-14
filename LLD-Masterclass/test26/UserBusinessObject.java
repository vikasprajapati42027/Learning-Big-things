import java.util.ArrayList;
import java.util.List;

public class UserBusinessObject {
    List<UserDTO> users = new ArrayList<>();

    public UserBusinessObject() {
        users.add(new UserDTO("Vikas", "v@test.com"));
        users.add(new UserDTO("Amit", "a@test.com"));
    }

    public List<UserDTO> getAllUsers() { return users; }
}
