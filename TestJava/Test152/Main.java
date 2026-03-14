package TestJava.Test152;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 152: Handling HTTP GET & Query Parameters ===\n");

        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        
        server.createContext("/search", exchange -> {
            // "GET" is usually the default, but it's good practice to check
            if ("GET".equals(exchange.getRequestMethod())) {
                
                // Extract the query string from the URI (e.g., "query=java&sort=desc")
                String queryTemplate = exchange.getRequestURI().getQuery();
                System.out.println("[Server] Raw Query String: " + queryTemplate);
                
                // Parse it manually (Built-in server doesn't auto-parse queries!)
                Map<String, String> queryParams = parseQuery(queryTemplate);
                
                String searchTerm = queryParams.getOrDefault("q", "Nothing");
                
                String response = "Search Results for: " + searchTerm;
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) { os.write(response.getBytes()); }
            } else {
                // Return 405 Method Not Allowed
                exchange.sendResponseHeaders(405, -1);
            }
        });
        
        server.start();

        // --- Client Test ---
        System.out.println("[Client] Sending GET request to /search?q=Multithreading");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/search?q=Multithreading"))
                .GET().build();
                
        HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("[Client] Response: " + res.body());
        
        server.stop(0);
    }
    
    // Helper method to parse query parameters manually
    private static Map<String, String> parseQuery(String query) {
        Map<String, String> result = new HashMap<>();
        if (query == null) return result;
        
        for (String param : query.split("&")) {
            String[] pair = param.split("=");
            if (pair.length > 1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }
}
