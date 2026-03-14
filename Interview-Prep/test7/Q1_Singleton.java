/**
 * Interviewer: How to implement a thread-safe Singleton?
 * Candidate: Use Double-Checked Locking or Initialization-on-demand holder idiom.
 */
class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private DatabaseConnection() { System.out.println("Creating DB Connection..."); }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
}

public class Q1_Singleton {
    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        System.out.println("Same Instance? " + (conn1 == conn2));
    }
}
