package TestJava.Test105;

import java.net.URI;
import java.nio.file.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Zip FileSystem (Reading Zip Files Natively) ===\n");

        // Java NIO can treat a Zip file as if it were a normal Virtual Hard Drive!
        // No need to use ancient ZipInputStream logic.

        Path zipPath = Paths.get("TestJava/Test105/archive.zip");
        Files.createDirectories(zipPath.getParent());

        // We use a special URI scheme: "jar:file:/..."
        URI uri = URI.create("jar:" + zipPath.toUri());

        // Properties: create it if it doesn't exist
        var env = Collections.singletonMap("create", "true");

        System.out.println("--- 1. Creating and writing to a Virtual Zip Filesystem ---");
        try (FileSystem zipFs = FileSystems.newFileSystem(uri, env)) {
            
            // Create a virtual file inside the zip!
            Path internalFilePath = zipFs.getPath("/virtual_file.txt");
            
            byte[] content = "This file only exists inside the Zip!".getBytes();
            Files.write(internalFilePath, content);
            System.out.println("Wrote file seamlessly inside the archive.");
        }
        
        System.out.println("\n--- 2. Reading from the Zip Filesystem ---");
        try (FileSystem zipFs = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
            
            Path internalFilePath = zipFs.getPath("/virtual_file.txt");
            
            // We can read it using standard NIO methods!
            String text = Files.readString(internalFilePath);
            System.out.println("Read from inside zip: " + text);
        }
        
        // Cleanup
        Files.delete(zipPath);
        System.out.println("\nZip filesystem demo complete.");
    }
}
