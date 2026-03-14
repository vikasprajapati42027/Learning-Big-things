package TestJava.Test159;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 159: Implementing CORS Headers ===\n");

        System.out.println("When a browser running on http://localhost:3000 (React/Angular) tries to");
        System.out.println("fetch data from an API on http://localhost:8086, the browser BLOCKS IT!");
        System.out.println("This is called a CORS error (Cross-Origin Resource Sharing).");
        System.out.println("To fix it, the SERVER must return specific headers!\n");

        HttpServer server = HttpServer.create(new InetSocketAddress(8086), 0);
        
        server.createContext("/api/data", exchange -> {
            
            // 1. Set the magic CORS Headers!
            // This says: "I allow any website to read my data!"
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            
            // Allow specific HTTP methods
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            
            // Allow custom headers (like Authorization)
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, Authorization");

            // 2. Preflight Request Handling
            if ("OPTIONS".equals(exchange.getRequestMethod())) {
                // Browsers send a preflight "OPTIONS" request before a POST to ask permission.
                // We just reply with 204 No Content for it.
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            // Normal GET request handling
            String response = "{\"status\": \"CORS enabled successfully!\"}";
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) { os.write(response.getBytes()); }
        });
        
        server.start();

        // --- Client Test ---
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("http://localhost:8086/api/data")).build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("[Client] Server allowed Origins: " + res.headers().firstValue("Access-Control-Allow-Origin").orElse("NONE"));
        System.out.println("[Client] Server allowed Methods: " + res.headers().firstValue("Access-Control-Allow-Methods").orElse("NONE"));
        System.out.println("[Client] Body: " + res.body());
        
        server.stop(0);
    }
}
