public class DTODemo {
    public static void main(String[] args) {
        UserBusinessObject ubo = new UserBusinessObject();

        for (UserDTO user : ubo.getAllUsers()) {
            System.out.println("User: [Name: " + user.getName() + ", Email: " + user.getEmail() + "]");
        }
    }
}
