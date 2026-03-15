/**
 * INTERVIEWER: Hibernate Topic 1.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
public class Q1_Hibernate {
    static class User {
        private final Long id;
        private final String username;
        private final String email;

        User(Long id, String username, String email) {
            this.id = id;
            this.username = username;
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{id=" + id + ", username='" + username + "', email='" + email + "'}";
        }
    }

    static class MetadataPrinter {
        void print(Class<?> clazz) {
            System.out.println("Simulated entity mapping for: " + clazz.getSimpleName());
        }
    }

    public static void main(String[] args) {
        User user = new User(100L, "alice", "alice@example.com");
        new MetadataPrinter().print(User.class);
        System.out.println("Entity ready: " + user);
    }
}
