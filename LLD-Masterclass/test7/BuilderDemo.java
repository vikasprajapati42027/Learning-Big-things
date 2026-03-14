public class BuilderDemo {
    public static void main(String[] args) {
        // Build a user with only required fields
        User u1 = new User.UserBuilder("Vikas", "P").build();
        System.out.println(u1);

        // Build a user with optional fields in any order
        User u2 = new User.UserBuilder("Amit", "Kumar")
                        .age(25)
                        .phone("9876543210")
                        .build();
        System.out.println(u2);
        
        // Final result: Easy to read, no confusing long constructors!
    }
}
