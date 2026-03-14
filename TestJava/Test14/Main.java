package TestJava.Test14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Serialization & Deserialization ===");
        
        UserProfile user = new UserProfile("admin_vikas", "super_secret_password");
        String filename = "TestJava/Test14/user.ser";

        System.out.println("\n--- 1. Serialization (Saving Object state to file) ---");
        System.out.println("Original Object: " + user);

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
             
            out.writeObject(user); // Magically converts the object into a byte stream!
            System.out.println("Successfully serialized UserProfile to " + filename);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- 2. Deserialization (Recreating Object from file) ---");
        UserProfile loadedUser = null;
        
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
             
            loadedUser = (UserProfile) in.readObject(); // Reads the bytes and constructs the object
            System.out.println("Successfully deserialized UserProfile from " + filename);
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Notice that the password will be 'null' because it was marked as 'transient'!
        System.out.println("Loaded Object: " + loadedUser);
    }
}
