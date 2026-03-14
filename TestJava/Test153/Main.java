package TestJava.Test153;

import com.sun.net.httpserver.HttpServer;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 153: Handling HTTP POST and Request Body ===\n");

        HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);
        
        server.createContext("/submit", exchange -> {
            if ("POST".equals(exchange.getRequestMethod())) {
                
                // 1. Read the HTTP Request Body (The payload being sent to us)
                try (InputStream is = exchange.getRequestBody()) {
                    String body = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                    System.out.println("[Server] Received Payload: " + body);
                    
                    // Respond back to the client
                    String response = "Successfully processed your data!";
                    exchange.sendResponseHeaders(201, response.length()); // 201 Created
                    try (OutputStream os = exchange.getResponseBody()) { 
                        os.write(response.getBytes()); 
                    }
                }
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        });
        
        server.start();

        // --- Client Test ---
        String jsonPayload = """
            {
                "username": "admin_vikas",
                "role": "SUPERUSER"
            }
            """;
            
        System.out.println("[Client] Sending POST request to /submit with JSON payload...");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8082/submit"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();
                
        HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("[Client] Status Code: " + res.statusCode());
        System.out.println("[Client] Response: " + res.body());
        
        server.stop(0);
    }
}
