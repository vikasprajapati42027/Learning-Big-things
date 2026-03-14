package TestJava.Test100;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Traversing directories using the high-performance NIO Files package
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("=== DirectoryStream & FileVisitor ===\n");

        Path targetDir = Paths.get("TestJava");

        System.out.println("--- 1. DirectoryStream (Shallow List) ---");
        // Preferred over file.listFiles() for massive directories because it streams results!
        // We only look for directories ending with "5" (TestJava/Test5, TestJava/Test25, etc)
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(targetDir, "*5")) {
            for (Path entry : stream) {
                System.out.println("Found match: " + entry.getFileName());
            }
        }

        System.out.println("\n--- 2. FileVisitor (Deep Tree Walk) ---");
        // Used to recursively walk down a folder tree!
        // SimpleFileVisitor lets us override only the methods we care about.
        
        Path startPath = Paths.get("TestJava/Test100");
        Files.createDirectories(startPath); // Make sure it exists for the test
        
        Files.walkFileTree(targetDir, new SimpleFileVisitor<Path>() {
            int javaFileCount = 0;

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (file.toString().endsWith(".java")) {
                    javaFileCount++;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                // We've processed the entire TestJava folder tree
                if (dir.equals(targetDir)) {
                    System.out.println("Finished walking tree. Total .java files found: " + javaFileCount);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
