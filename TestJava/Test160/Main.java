package TestJava.Test160;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

// This framework completely abstracts the ugly Sun HttpServer API!
class MiniApp {
    private HttpServer server;
    // Map of HTTP Method -> (Map of Path -> Handler Logic)
    private Map<String, Map<String, CustomHandler>> routes = new HashMap<>();

    public interface CustomHandler {
        String handle(HttpExchange req) throws Exception;
    }

    public MiniApp(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        routes.put("GET", new HashMap<>());
        routes.put("POST", new HashMap<>());

        // A single master handler intercepts ALL requests
        server.createContext("/", exchange -> {
            String method = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath();
            
            CustomHandler handler = routes.get(method).get(path);
            
            try {
                if (handler != null) {
                    // Execute the clean lambda logic
                    String response = handler.handle(exchange);
                    exchange.sendResponseHeaders(200, response.length());
                    try (OutputStream os = exchange.getResponseBody()) { os.write(response.getBytes()); }
                } else {
                    String err = "404 Not Found";
                    exchange.sendResponseHeaders(404, err.length());
                    try (OutputStream os = exchange.getResponseBody()) { os.write(err.getBytes()); }
                }
            } catch (Exception e) {
                exchange.sendResponseHeaders(500, -1);
            }
        });
    }

    // Builder methods like Express.js/SparkJava!
    public void get(String path, CustomHandler handler) {
        routes.get("GET").put(path, handler);
    }

    public void post(String path, CustomHandler handler) {
        routes.get("POST").put(path, handler);
    }

    public void start() { server.start(); }
    public void stop() { server.stop(0); }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 160: Mini Web Framework Integration ===\n");

        System.out.println("Let's combine everything into a Spring/Express style syntax!\n");

        MiniApp app = new MiniApp(8087);
        
        // --- Extremely clean routing! ---
        app.get("/", req -> "Welcome to MiniApp Framework!");
        app.get("/users", req -> "[{\"name\":\"Alice\"}, {\"name\":\"Bob\"}]");
        app.post("/users", req -> "User Created Successfully.");
        
        app.start();

        // --- Client Test ---
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest req1 = HttpRequest.newBuilder().uri(URI.create("http://localhost:8087/")).build();
        System.out.println("GET /      -> " + client.send(req1, HttpResponse.BodyHandlers.ofString()).body());
        
        HttpRequest req2 = HttpRequest.newBuilder().uri(URI.create("http://localhost:8087/users")).build();
        System.out.println("GET /users -> " + client.send(req2, HttpResponse.BodyHandlers.ofString()).body());
        
        HttpRequest req3 = HttpRequest.newBuilder().uri(URI.create("http://localhost:8087/users")).POST(HttpRequest.BodyPublishers.noBody()).build();
        System.out.println("POST /users-> " + client.send(req3, HttpResponse.BodyHandlers.ofString()).body());
        
        app.stop();
    }
}
