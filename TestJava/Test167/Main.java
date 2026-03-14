package TestJava.Test167;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 167: BLOB & CLOB (Storing Files in DB) ===\n");

        System.out.println("BLOB (Binary Large OBject): Used for Images, Audio, PDF files.");
        System.out.println("CLOB (Character Large OBject): Used for massive text logs, XML, JSON.\n");

        // Create a dummy file
        File imageFile = new File("dummy_image.png");
        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            fos.write(new byte[]{ (byte)0xFF, (byte)0xD8, (byte)0xFF }); // Fake JPEG/PNG bytes
        }
        
        System.out.println("Dummy image created. Now streaming it to the Database...");

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:blob.db");
            
            // 1. Storing a BLOB
            String insertSql = "INSERT INTO files (filename, data) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertSql);
                 FileInputStream fis = new FileInputStream(imageFile)) {
                 
                ps.setString(1, "dummy_image.png");
                
                // We don't read the file into a giant byte[] in Java! That causes OutOfMemory.
                // We pass the InputStream directly to the JDBC driver!
                ps.setBinaryStream(2, fis, imageFile.length());
                
                ps.executeUpdate();
                System.out.println("Image saved as BLOB successfully.");
            }
            
            // 2. Reading a BLOB using InputStream
            String selectSql = "SELECT data FROM files WHERE filename = ?";
            try (PreparedStatement ps = conn.prepareStatement(selectSql)) {
                ps.setString(1, "dummy_image.png");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    InputStream dbStream = rs.getBinaryStream("data");
                    System.out.println("Stream completely retrieved from DB! Length: " + dbStream.available() + " bytes");
                }
            }
            
            conn.close();
        } catch (SQLException e) {
            System.out.println("[Demo Mode] BLOB/CLOB streaming concepts explained conceptually.");
        } finally {
            imageFile.delete();
        }
    }
}
