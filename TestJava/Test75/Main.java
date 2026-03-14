package TestJava.Test75;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

// --- 1. Java 14 Records & Validation ---
record ServerNode(UUID id, String status, int loadScore) {
    public ServerNode {
        if (loadScore < 0 || loadScore > 100) {
            throw new IllegalArgumentException("Load must be between 0 and 100");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== GRAND FINALE 2: Putting It All Together ===\n");

        // --- 2. Java 9 Collection Factory & UUID ---
        List<ServerNode> nodes = List.of(
            new ServerNode(UUID.randomUUID(), "ACTIVE", 45),
            new ServerNode(UUID.randomUUID(), "ACTIVE", 85),
            new ServerNode(UUID.randomUUID(), "DOWN", 0),
            new ServerNode(UUID.randomUUID(), "ACTIVE", 92)
        );

        // --- 3. CompletableFuture (Async) ---
        System.out.println("[Main] Initiating Server Health Check...");
        
        CompletableFuture<Void> healthCheck = CompletableFuture.supplyAsync(() -> {
            System.out.println("\n[Async] -> Analyzing " + nodes.size() + " server nodes...");
            
            // --- 4. Stream API (Filtering & Mapping) ---
            List<ServerNode> highLoadNodes = nodes.stream()
                .filter(n -> "ACTIVE".equals(n.status()))
                .filter(n -> n.loadScore() > 80)
                .collect(Collectors.toList());
            
            return highLoadNodes;
            
        }).thenAcceptAsync(warnings -> {
            System.out.println("\n[Async] -> Critical Servers Found: " + warnings.size());
            
            // --- 5. Text Blocks & String Formatting ---
            for (var node : warnings) { // using 'var'
                String alert = """
                        !!! ALERT !!!
                        Server ID  : %s
                        Load Level : %d%%
                        Status     : REQUIRES BALANCING
                        """;
                System.out.printf(alert, node.id(), node.loadScore());
            }
        });

        System.out.println("[Main] Doing other work while async tasks run...\n");
        healthCheck.join(); // Block until async workflow is complete

        System.out.println("=== Tutorial Series 51-75 Completed! ===");
    }
}
