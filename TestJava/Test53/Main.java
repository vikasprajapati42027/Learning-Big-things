package TestJava.Test53;

import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java Properties Tutorial ===\n");

        // Properties are basically a Hashtable where both keys and values are STRINGS.
        // They are heavily used in Java for configuration files (like application.properties in Spring).
        
        Properties appConfig = new Properties();
        String configFile = "TestJava/Test53/config.properties";

        // --- 1. Setting Properties ---
        System.out.println("--- 1. Setting Properties ---");
        appConfig.setProperty("db.url", "localhost:3306");
        appConfig.setProperty("db.user", "admin");
        appConfig.setProperty("db.password", "secret123");
        
        // --- 2. Saving to a File ---
        try (FileOutputStream output = new FileOutputStream(configFile)) {
            // This writes the properties to a file in an standard key=value format
            appConfig.store(output, "Database Configuration Settings");
            System.out.println("Saved properties to " + configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- 3. Loading from a File ---
        System.out.println("\n--- 2. Loading Properties ---");
        Properties loadedConfig = new Properties();
        
        try (FileInputStream input = new FileInputStream(configFile)) {
            loadedConfig.load(input);
            System.out.println("Loaded properties successfully!");
            
            // Getting a property
            System.out.println("DB User: " + loadedConfig.getProperty("db.user"));
            
            // Getting a property with a fallback default value (if the key doesn't exist)
            System.out.println("App Port: " + loadedConfig.getProperty("app.port", "8080"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Cleanup file
        new java.io.File(configFile).delete();
    }
}
