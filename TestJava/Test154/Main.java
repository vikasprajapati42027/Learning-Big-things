package TestJava.Test154;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 154: Routing and HttpContext ===\n");

        System.out.println("A real server needs multiple endpoints (routes). We use contexts for that.");

        HttpServer server = HttpServer.create(new InetSocketAddress(8083), 0);
        
        // Route 1: Users API
        server.createContext("/api/users", exchange -> {
            String response = "[{\"id\":1, \"name\":\"Vikas\"}, {\"id\":2, \"name\":\"Java\"}]";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) { os.write(response.getBytes()); }
        });
        
        // Route 2: Orders API
        server.createContext("/api/orders", exchange -> {
            String response = "Order #999 created successfully.";
            exchange.sendResponseHeaders(201, response.length());
            try (OutputStream os = exchange.getResponseBody()) { os.write(response.getBytes()); }
        });
        
        server.start();

        // --- Client Test ---
        HttpClient client = HttpClient.newHttpClient();
        
        System.out.println("\n[Client] Hitting Users API...");
        HttpRequest req1 = HttpRequest.newBuilder().uri(URI.create("http://localhost:8083/api/users")).build();
        System.out.println("Result: " + client.send(req1, HttpResponse.BodyHandlers.ofString()).body());
        
        System.out.println("\n[Client] Hitting Orders API...");
        HttpRequest req2 = HttpRequest.newBuilder().uri(URI.create("http://localhost:8083/api/orders")).POST(HttpRequest.BodyPublishers.noBody()).build();
        System.out.println("Result: " + client.send(req2, HttpResponse.BodyHandlers.ofString()).body());
        
        server.stop(0);
    }
}
