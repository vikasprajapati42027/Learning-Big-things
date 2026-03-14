package TestJava.Test163;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 163: ResultSet & DatabaseMetaData ===\n");

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");

            // 1. DatabaseMetaData (Extracting info about the DB itself!)
            DatabaseMetaData dbMeta = conn.getMetaData();
            System.out.println("Driver Name: " + dbMeta.getDriverName());
            System.out.println("Driver Version: " + dbMeta.getDriverVersion());

            // 2. Querying Data
            String sql = "SELECT id, name, age FROM users";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                
                // 3. ResultSetMetaData (Extracting info about the Columns!)
                ResultSetMetaData rsMeta = rs.getMetaData();
                int columnCount = rsMeta.getColumnCount();
                System.out.println("Columns in result: " + columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Column " + i + ": " + rsMeta.getColumnName(i) + " (" + rsMeta.getColumnTypeName(i) + ")");
                }

                System.out.println("\n--- Data Rows ---");
                // ResultSet is a cursor. rs.next() moves to the next row and returns true if it exists.
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.printf("Row: ID=%d, Name=%s, Age=%d%n", id, name, age);
                }
            }
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("[Demo Mode] This is how you read data using ResultSet and inspect schemas using MetaData!");
        }
    }
}
