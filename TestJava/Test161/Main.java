package TestJava.Test161;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 161: SQLite Setup & Basic JDBC Connection ===\n");

        System.out.println("JDBC (Java Database Connectivity) is the standard API for connecting to Relational Databases.");
        System.out.println("To actually connect, you need a 'Driver' JAR file (like sqlite-jdbc.jar or mysql-connector.jar).");
        System.out.println("But the code you write uses standard 'java.sql' interfaces!\n");

        String url = "jdbc:sqlite:test.db"; // SQLite uses a local file
        
        System.out.println("Attempting to connect to: " + url);

        // Standard try-with-resources closes the connection automatically!
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            
            System.out.println("[Success] Connected to Database!");
            
            String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT)";
            stmt.execute(sql);
            System.out.println("[Success] Table created.");

        } catch (SQLException e) {
            System.out.println("\n[Expected Error] " + e.getMessage());
            System.out.println("-> Why? Because we didn't add 'sqlite-jdbc.jar' to our classpath!");
            System.out.println("-> In a real project (Maven/Gradle), you just add the dependency and this exact code works perfectly.");
        }
    }
}
