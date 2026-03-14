package TestJava.Test41;

// To use Try-with-Resources, the class MUST implement AutoCloseable or Closeable
class DatabaseConnection implements AutoCloseable {
    public DatabaseConnection() {
        System.out.println("Opening Database Connection...");
    }

    public void query(String sql) {
        System.out.println("Executing Query: " + sql);
        // Simulate a crash during execution
        if (sql.contains("DROP")) {
            throw new RuntimeException("ERROR: Unsafe query detected!");
        }
    }

    // This method is AUTOMATICALLY called at the end of the try block, 
    // EVEN IF AN EXCEPTION OCCURS! No finally block needed!
    @Override
    public void close() {
        System.out.println("Closing Database Connection securely!");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Try-with-Resources (Java 7+) ===");

        // The resource is declared inside the parenthesis of the try statement
        try (DatabaseConnection db = new DatabaseConnection()) {
            db.query("SELECT * FROM users");
            db.query("DROP TABLE users"); // This will throw an exception
            System.out.println("This line will never be reached.");
            
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        
        System.out.println("Notice how 'close()' was called BEFORE the catch block finished!");
    }
}
