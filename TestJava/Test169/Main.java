package TestJava.Test169;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 169: CachedRowSet vs ResultSet ===\n");

        System.out.println("Problems with standard ResultSet:");
        System.out.println("1. It is 'Connected'. If you close the Connection, the ResultSet dies.");
        System.out.println("2. You can't easily pass it to a UI layer or serialize it.\n");
        
        System.out.println("Solution: CachedRowSet (A disconnected, serialized copy of the data!)\n");

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            
            // 1. We start with a standard connected ResultSet
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            
            // 2. We pour the data into a CachedRowSet
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(rs); 
            
            System.out.println("Data successfully populated into CachedRowSet!");
            
            // 3. WE COMPLETELY CLOSE THE DATABASE CONNECTION!
            rs.close();
            ps.close();
            conn.close();
            System.out.println("Database connection closed!\n");
            
            // 4. We can still read, modify, and stream data from the CachedRowSet!
            System.out.println("Reading offline data:");
            while (crs.next()) {
                System.out.println("ID: " + crs.getInt(1) + ", Name: " + crs.getString(2));
            }
            
        } catch (Exception e) {
            System.out.println("[Demo Mode] Since we don't have the Sqlite driver, the query failed.");
            System.out.println("However, the CachedRowSet provider (RowSetProvider.newFactory()) is built into modern Java.");
        }
    }
}
