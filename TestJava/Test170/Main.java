package TestJava.Test170;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 170: Stored Procedures (CallableStatement) ===\n");

        System.out.println("A Stored Procedure is Java-like logic written directly inside the Database (using PL/SQL, T-SQL).");
        System.out.println("CallableStatement lets Java execute those remote DB functions natively!\n");

        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"); // Mocking an Oracle string
            
            // Let's assume the Database has a procedure:
            // PROCEDURE calculate_discount(employee_id IN INT, discount OUT DECIMAL)
            
            // The syntax is always {call procedure_name(?, ?)}
            String sql = "{call validate_login(?, ?)}";
            
            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                
                // 1. Set the IN parameter (Username passed to the DB)
                cstmt.setString(1, "vikas_user");
                
                // 2. Register the OUT parameter (The DB will write the boolean result here!)
                cstmt.registerOutParameter(2, Types.BOOLEAN);
                
                // 3. Execute the remote DB code!
                System.out.println("Calling database procedure...");
                cstmt.execute();
                
                // 4. Retrieve the mutatedOUT variable
                boolean loginSuccess = cstmt.getBoolean(2);
                System.out.println("Procedure Result - Login Success: " + loginSuccess);
            }
            
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("[Demo Mode] CallableStatement concepts explained conceptually.");
            System.out.println("Calling stored procedures looks exactly like this. The '{}' braces tell the JDBC driver to escape the call natively.");
        }
    }
}
