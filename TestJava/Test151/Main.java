package TestJava.Test151;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 151: Simple HttpServer Setup ===\n");

        System.out.println("Java comes with a built-in production-ready HTTP Server!");
        System.out.println("It's highly performant and often used in microservices to avoid heavy frameworks like Spring.\n");

        int port = 8080;
        
        // 1. Create the server
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // 2. Map a "Context" (a URL route) to a Handler logic
        server.createContext("/hello", exchange -> {
            String response = "Hello from Native Java HTTP Server!";
            
            // 200 OK, length of response
            exchange.sendResponseHeaders(200, response.length());
            
            // Write the body
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });
        
        // 3. Set a default executor (Thread pool). null means it will run on the current thread.
        server.setExecutor(null); 
        
        // 4. Start the server
        System.out.println("[Server] Starting on port " + port + "... (Endpoint: http://localhost:8080/hello)");
        server.start();

        // -------------------------------------------------------------
        // AUTOMATED TEST CLIENT (To prove it works in this tutorial)
        // -------------------------------------------------------------
        System.out.println("\n[Client] Sending test request...");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/hello"))
                .GET()
                .build();
                
        HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("[Client] Server replied: " + res.body());
        
        // Automatically stop the server so the script can finish
        System.out.println("\n[Server] Shutting down...");
        server.stop(0);
    }
}
