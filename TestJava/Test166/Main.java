package TestJava.Test166;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 166: Batch Processing (executeBatch) ===\n");

        System.out.println("Executing 10,000 INSERT statements one-by-one is terribly slow because");
        System.out.println("of network latency. Batch Processing sends them all at once!\n");

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:batch_test.db");
            conn.setAutoCommit(false); // Transactions + Batching = Ultra Fast!
            
            String sql = "INSERT INTO logs (message) VALUES (?)";
            
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                
                System.out.println("Adding 5 queries to the batch...");
                for (int i = 1; i <= 5; i++) {
                    ps.setString(1, "Log message " + i);
                    
                    // Add this specific parameter set to the batch (Don't execute yet!)
                    ps.addBatch();
                }
                
                // Execute ALL of them in one single network round-trip!
                int[] results = ps.executeBatch();
                System.out.println("Executed " + results.length + " statements in one go!");
                
                conn.commit();
            }
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("[Demo Mode] Batch Processing concepts explained conceptually.");
        }
    }
}
