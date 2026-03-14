package TestJava.Test155;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
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
        System.out.println("=== Test 155: HttpFilter for Authentication ===\n");

        System.out.println("Filters intercept requests BEFORE they reach the handler. Great for Auth & Logging!");

        HttpServer server = HttpServer.create(new InetSocketAddress(8084), 0);
        
        // 1. Create a secure route handler
        HttpContext context = server.createContext("/secure/data", exchange -> {
            String response = "Secret Financial Data: $1,000,000";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) { os.write(response.getBytes()); }
        });
        
        // 2. Attach a Custom Filter to the Context
        context.getFilters().add(new Filter() {
            @Override
            public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
                // Check for authorization header
                String authHeader = exchange.getRequestHeaders().getFirst("Authorization");
                
                if ("Bearer SECRET-TOKEN-123".equals(authHeader)) {
                    System.out.println("[Filter] Auth Success! Forwarding to Handler...");
                    // Pass the request down the chain to the actual handler
                    chain.doFilter(exchange); 
                } else {
                    System.out.println("[Filter] Auth Failed! Blocking request.");
                    String error = "401 Unauthorized";
                    exchange.sendResponseHeaders(401, error.length());
                    try (OutputStream os = exchange.getResponseBody()) { os.write(error.getBytes()); }
                }
            }
            
            @Override
            public String description() { return "Authentication Filter"; }
        });
        
        server.start();

        // --- Client Test ---
        HttpClient client = HttpClient.newHttpClient();
        
        System.out.println("\n[Client] Scenario 1: Accessing without a token...");
        HttpRequest req1 = HttpRequest.newBuilder().uri(URI.create("http://localhost:8084/secure/data")).build();
        System.out.println("Response: " + client.send(req1, HttpResponse.BodyHandlers.ofString()).body());
        
        System.out.println("\n[Client] Scenario 2: Accessing WITH the correct token...");
        HttpRequest req2 = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8084/secure/data"))
                .header("Authorization", "Bearer SECRET-TOKEN-123")
                .build();
        System.out.println("Response: " + client.send(req2, HttpResponse.BodyHandlers.ofString()).body());
        
        server.stop(0);
    }
}
