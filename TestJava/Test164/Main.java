package TestJava.Test164;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 164: Transaction Management (Commit & Rollback) ===\n");

        System.out.println("By default, JDBC uses 'Auto-Commit' mode. Every SQL statement represents a single transaction.");
        System.out.println("If you are transferring money from Account A to Account B, you need BOTH updates to succeed or fail together!\n");
        
        System.out.println("Here is the bulletproof pattern for Transactions:\n");

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
            
            // 1. TURN OFF AUTO-COMMIT!
            conn.setAutoCommit(false);
            
            try (PreparedStatement deductStmt = conn.prepareStatement("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
                 PreparedStatement addStmt = conn.prepareStatement("UPDATE accounts SET balance = balance + 100 WHERE id = 2")) {
                 
                // Perform Operations
                deductStmt.executeUpdate();
                System.out.println("Deducted $100 from Account 1...");
                
                // Simulate an unexpected crash/error in the middle!
                if (true) throw new RuntimeException("Simulated Server Crash!");
                
                addStmt.executeUpdate();
                System.out.println("Added $100 to Account 2...");
                
                // 2. COMMIT ONLY IF EVERYTHING SUCCEEDED!
                conn.commit();
                System.out.println("Transaction Completed Successfully.");
                
            } catch (Exception e) {
                // 3. ROLLBACK EVERYTHING IF ANY ERROR OCCURS!
                System.out.println("CRASH DETECTED! Rolling back ALL changes...");
                conn.rollback();
                System.out.println("Rollback successful. Account 1's money was restored securely.");
            } finally {
                // Restore auto-commit before returning connection to a pool
                conn.setAutoCommit(true);
            }
            
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("[Demo Mode] Transaction concepts explained conceptually.");
        }
    }
}
