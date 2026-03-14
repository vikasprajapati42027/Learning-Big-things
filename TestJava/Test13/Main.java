package TestJava.Test13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Modern File I/O (java.nio) Tutorial ===");
        
        // Define the path where we want to create our file
        // We'll put it right in the Test13 folder
        Path filePath = Paths.get("TestJava/Test13/demo_file.txt");
        
        System.out.println("\n--- 1. Writing to a File ---");
        try {
            String contentToWrite = "Hello Java NIO!\nThis is a second line of text.\nWriting files is easy now.";
            // Files.writeString creates the file if it doesn't exist, and overwrites it if it does
            Files.writeString(filePath, contentToWrite);
            System.out.println("Successfully created and wrote to: " + filePath.getFileName());
            
            // Appending more text to the SAME file without overwriting
            Files.writeString(filePath, "\nThis line was APPENDED later.", StandardOpenOption.APPEND);
            System.out.println("Successfully appended a new line.");
            
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("\n--- 2. Reading from a File ---");
        try {
            // Read ALL lines into a List of Strings in one go
            List<String> allLines = Files.readAllLines(filePath);
            
            System.out.println("Reading contents of " + filePath.getFileName() + ":");
            for (int i = 0; i < allLines.size(); i++) {
                System.out.println("Line " + (i + 1) + ": " + allLines.get(i));
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n--- 3. File Metadata ---");
        try {
            System.out.println("File exists? " + Files.exists(filePath));
            System.out.println("File size (bytes): " + Files.size(filePath));
            
            // Clean up: delete the file so we don't leave a mess
            System.out.println("\nCleaning up... deleting demo_file.txt");
            Files.delete(filePath);
            System.out.println("File deleted successfully: " + !Files.exists(filePath));
            
        } catch (IOException e) {
            System.out.println("Error checking or deleting file: " + e.getMessage());
        }
    }
}
