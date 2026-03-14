/**
 * Interviewer: When to use the Builder Pattern?
 * Candidate: When an object has many optional parameters and would require a messy constructor (Telescoping Constructor).
 */
class User {
    private final String firstName; // Required
    private final String lastName;  // Required
    private final int age;          // Optional
    private final String phone;     // Optional

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;

        public UserBuilder(String first, String last) { this.firstName = first; this.lastName = last; }
        public UserBuilder age(int age) { this.age = age; return this; }
        public UserBuilder phone(String phone) { this.phone = phone; return this; }
        public User build() { return new User(this); }
    }

    @Override
    public String toString() { return "User: " + firstName + " " + lastName + ", Age: " + age; }
}

public class Q3_Builder_Pattern {
    public static void main(String[] args) {
        User user = new User.UserBuilder("Vikas", "P").age(25).build();
        System.out.println(user);
    }
}
