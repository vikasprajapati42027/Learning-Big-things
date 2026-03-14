package TestJava.Test99;

import java.nio.file.Path;
import java.nio.file.Paths;

// The java.nio.file.Path interface (Java 7+) is the modern replacement for java.io.File.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Path Operations (java.nio.file.Path) ===\n");

        Path path = Paths.get("/home/user/project/src/Main.java");

        System.out.println("--- 1. Path Information ---");
        System.out.println("Original Path: " + path);
        System.out.println("File Name: " + path.getFileName());
        System.out.println("Parent: " + path.getParent());
        System.out.println("Root: " + path.getRoot());

        System.out.println("\n--- 2. Resolve (Combining Paths) ---");
        // resolve() appends the given string to the path
        Path projectDir = Paths.get("/home/user/project");
        Path docs = projectDir.resolve("docs/readme.txt");
        System.out.println("Resolved Path: " + docs);

        System.out.println("\n--- 3. Relativize (Finding relative difference) ---");
        // relativize() constructs a relative path between two paths
        Path path1 = Paths.get("/home/user/project/src/code");
        Path path2 = Paths.get("/home/user/project/images");
        
        // How to get from path1 -> to -> path2?
        Path relativePath = path1.relativize(path2);
        System.out.println("Relative from code to images: " + relativePath);
        // Result: ../../images  (Go up two levels, then into images)

        System.out.println("\n--- 4. Normalize (Cleaning up redundancies) ---");
        // Removes "." and resolves ".." directory traversals
        Path dirtyPath = Paths.get("/home/user/./project/src/../docs/index.html");
        System.out.println("Dirty Path  : " + dirtyPath);
        System.out.println("Normalized  : " + dirtyPath.normalize());
    }
}
