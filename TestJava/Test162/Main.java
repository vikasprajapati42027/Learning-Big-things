package TestJava.Test162;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 162: PreparedStatement (SQL Injection Prevention) ===\n");

        System.out.println("NEVER use normal Statement and String Concatenation for user input.");
        System.out.println("Example of BAD code: stmt.execute(\"SELECT * FROM users WHERE name = '\" + userInput + \"'\");");
        System.out.println("A hacker could type: ' OR '1'='1 --  and delete your database! (SQL Injection)\n");
        
        System.out.println("Solution: PreparedStatement!\n");

        String url = "jdbc:sqlite:test.db";
        String userInputName = "Vikas";
        int userInputAge = 28;

        try {
            // We simulate getting a connection. It will fail, but the code structure is correct.
            Connection conn = DriverManager.getConnection(url);

            // 1. Prepare the SQL using '?' placeholders
            String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                
                // 2. Safely bind the parameters! 
                // The JDBC driver will automatically escape dangerous characters.
                pstmt.setString(1, userInputName); // 1st question mark
                pstmt.setInt(2, userInputAge);     // 2nd question mark
                
                // 3. Execute!
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Rows inserted: " + rowsAffected);
            }
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("[Demo Mode] The driver is missing, but the code structure above is 100% production-ready for SQL.");
            System.out.println("Error caught: " + e.getMessage());
        }
    }
}
