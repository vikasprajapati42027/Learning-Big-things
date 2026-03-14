class BaseDTO { String type = "INFO"; }
class UserDTO extends BaseDTO { 
    String name;
    public UserDTO(String n) { name = n; }
}
public class DtoProjectionDemo {
    public static void main(String[] args) {
        UserDTO dto = new UserDTO("Vikas");
        System.out.println(dto.name + " [" + dto.type + "]");
    }
}
