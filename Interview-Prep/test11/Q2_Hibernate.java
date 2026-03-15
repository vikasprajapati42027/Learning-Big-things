/**
 * INTERVIEWER: Hibernate Topic 2.
 * CANDIDATE: Advanced Hibernate explanation and code.
 */
public class Q2_Hibernate {
    static class SessionFactory {
        private final String url;

        SessionFactory(String url) {
            this.url = url;
        }

        Session openSession() {
            System.out.println("Opening session against " + url);
            return new Session(url);
        }
    }

    static class Session implements AutoCloseable {
        private final String url;

        Session(String url) {
            this.url = url;
        }

        void beginTransaction() {
            System.out.println("Transaction started for " + url);
        }

        void close() {
            System.out.println("Session closed for " + url);
        }
    }

    public static void main(String[] args) {
        SessionFactory factory = new SessionFactory("jdbc:postgresql://localhost:5432/hibernate");
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            System.out.println("Session ready for CRUD operations.");
        }
    }
}
