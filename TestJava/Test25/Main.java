package TestJava.Test25;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 1. Using Records (Java 14+)
record SystemUser(int id, String name, String department) {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Grand Finale: Putting It All Together ===");

        Path dataFile = Paths.get("TestJava/Test25/users.csv");
        
        // 2. Using CompletableFuture (Async)
        CompletableFuture<Void> workflow = CompletableFuture.runAsync(() -> {
            System.out.println("\n[Async] -> Generating dummy data file...");
            createDummyData(dataFile);
        }).thenAcceptAsync(v -> {
            System.out.println("[Async] -> Processing data file using Streams...");
            List<SystemUser> users = loadUsers(dataFile);

            // 3. Advanced Streams, Lambdas, Method References
            System.out.println("\n--- IT Department Users ---");
            users.stream()
                 .filter(u -> u.department().equals("IT"))
                 .map(SystemUser::name)                      // Method Reference
                 .map(String::toUpperCase)                   // Method Reference
                 .forEach(System.out::println);              // Method Reference

            // 4. Optionals
            System.out.println("\n--- Searching for Employee ID 102 ---");
            findUserById(users, 102).ifPresentOrElse(
                user -> System.out.println("Found: " + user.name()),
                () -> System.out.println("User not found!")
            );

            System.out.println("\n--- Searching for Employee ID 999 ---");
            findUserById(users, 999).ifPresentOrElse(
                user -> System.out.println("Found: " + user.name()),
                () -> System.out.println("User not found!")
            );

        }).thenRunAsync(() -> {
            System.out.println("\n[Async] -> Cleaning up files...");
            try { Files.deleteIfExists(dataFile); } catch (IOException e) {}
            System.out.println("File deleted. Workflow complete.");
        });

        System.out.println("Main thread is free to do other things while Async workflow runs!");
        
        // Block main thread until workflow finishes
        workflow.join(); 
        
        System.out.println("\n=== Java Advanced Concepts Tour Finished! ===");
    }

    // Modern File I/O
    private static void createDummyData(Path path) {
        try {
            String data = "101,Alice,HR\n102,Bob,IT\n103,Charlie,Finance\n104,David,IT";
            Files.writeString(path, data);
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static List<SystemUser> loadUsers(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(line -> {
                String[] parts = line.split(",");
                return new SystemUser(Integer.parseInt(parts[0]), parts[1], parts[2]);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            return List.of();
        }
    }

    // Optional for safe null-handling
    private static Optional<SystemUser> findUserById(List<SystemUser> users, int id) {
        return users.stream()
                    .filter(u -> u.id() == id)
                    .findFirst();
    }
}
