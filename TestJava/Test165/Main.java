package TestJava.Test165;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 165: Savepoints in Transactions ===\n");

        System.out.println("Sometimes you don't want to rollback the ENTIRE transaction, just a specific part.");
        System.out.println("Savepoints allow you to set checkpoints within a single transaction!\n");

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:game.db");
            conn.setAutoCommit(false);
            
            // 1. Initial State (Player starts level)
            System.out.println("Creating player profile...");
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO players (name) VALUES ('Hero')")) {
                ps.executeUpdate();
            }

            // 2. Create a Savepoint! (Checkpoint 1)
            Savepoint checkpoint1 = conn.setSavepoint("Checkpoint1");
            System.out.println("Savepoint created: 'Checkpoint1'");

            try {
                // 3. Player enters boss fight (Updates stats)
                System.out.println("Player fights boss... loses 50 HP.");
                try (PreparedStatement ps = conn.prepareStatement("UPDATE players SET hp = hp - 50")) {
                    ps.executeUpdate();
                }
                
                // Simulate player dying
                throw new RuntimeException("Player Died!");
                
            } catch (Exception e) {
                // 4. Rollback to the savepoint instead of rolling back the player creation!
                System.out.println("Player Died! Rolling back to Checkpoint1...");
                conn.rollback(checkpoint1); 
            }
            
            // 5. Commit the transaction (Player creation is saved, but boss fight HP loss is rolled back)
            conn.commit();
            System.out.println("Transaction committed. Player exists with full HP!");
            
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("[Demo Mode] Savepoint concepts explained conceptually.");
        }
    }
}
