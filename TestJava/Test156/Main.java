package TestJava.Test156;

import com.sun.net.httpserver.HttpServer;
import java.io.File;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 156: Serving Static Files (HTML/CSS) ===\n");

        // 1. Create a dummy HTML file on the disk
        Path webDir = Path.of("TestJava/Test156/web");
        Files.createDirectories(webDir);
        Path htmlFile = webDir.resolve("index.html");
        
        String htmlContent = "<html><body><h1>Welcome to Java Native File Server!</h1></body></html>";
        Files.writeString(htmlFile, htmlContent);

        // 2. Setup the Server
        HttpServer server = HttpServer.create(new InetSocketAddress(8085), 0);
        
        server.createContext("/", exchange -> {
            // Extract requested file path from URI (e.g. "/" -> "/index.html")
            String requestPath = exchange.getRequestURI().getPath();
            if (requestPath.equals("/")) {
                requestPath = "/index.html"; 
            }
            
            File file = new File(webDir.toFile(), requestPath);
            
            if (file.exists() && !file.isDirectory()) {
                // Set the correct MIME type
                if (file.getName().endsWith(".html")) {
                    exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                }
                
                // Read bytes and send exactly that length
                byte[] bytes = Files.readAllBytes(file.toPath());
                exchange.sendResponseHeaders(200, bytes.length);
                
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(bytes);
                }
            } else {
                // 404 Not Found
                String error = "404 - File Not Found";
                exchange.sendResponseHeaders(404, error.length());
                try (OutputStream os = exchange.getResponseBody()) { os.write(error.getBytes()); }
            }
        });
        
        server.start();

        // --- Client Test ---
        HttpClient client = HttpClient.newHttpClient();
        
        System.out.println("[Client] Requesting / (which maps to index.html)...");
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("http://localhost:8085/")).build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Status: " + res.statusCode() + " | Content-Type: " + res.headers().firstValue("Content-Type").orElse(""));
        System.out.println("Body: " + res.body());
        
        server.stop(0);
        
        // Cleanup
        Files.deleteIfExists(htmlFile);
        Files.deleteIfExists(webDir);
    }
}
