package TestJava.Test202;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 202: Server-Sent Events (SSE) Concept ===\n");

        System.out.println("WebSockets are BI-DIRECTIONAL. SSE is UNI-DIRECTIONAL (Server -> Client).");
        System.out.println("Perfect for Live Cricket Scores, Stock Tickers, or ChatGPT streaming text!");
        System.out.println("The secret is Content-Type: text/event-stream and NEVER closing the connection!\n");

        // Start SSE Server
        HttpServer server = HttpServer.create(new InetSocketAddress(8089), 0);
        
        server.createContext("/stream", exchange -> {
            
            // 1. Set the magic Headers!
            exchange.getResponseHeaders().set("Content-Type", "text/event-stream");
            exchange.getResponseHeaders().set("Cache-Control", "no-cache");
            exchange.getResponseHeaders().set("Connection", "keep-alive");
            
            // Send HTTP 200 OK headers (Chunked Transfer Encoding = 0)
            exchange.sendResponseHeaders(200, 0); 
            
            OutputStream os = exchange.getResponseBody();
            
            try {
                // Send 3 events, one per second
                System.out.println("[Server] Client connected! Streaming 3 events...");
                for (int i = 1; i <= 3; i++) {
                    
                    // The standard SSE Format: "data: {JSON}\n\n"
                    String message = "data: {\"stockPrice\": " + (100 + i * 5) + "}\n\n";
                    
                    os.write(message.getBytes());
                    os.flush(); // FORCE data to immediately send across the network!
                    
                    Thread.sleep(1000); 
                }
            } catch (Exception e) {} finally {
                os.close(); // Only now do we close the connection
            }
        });
        
        server.start();

        // --- Client Test ---
        // Java 11+ HttpClient natively supports reading infinite streams using BodyHandlers.ofLines()
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("http://localhost:8089/stream")).build();
        
        System.out.println("[Client] Connecting to SSE Stream...");
        
        client.sendAsync(req, HttpResponse.BodyHandlers.ofLines())
              .thenAccept(response -> {
                  response.body().forEach(line -> {
                      if (!line.isEmpty()) {
                          System.out.println("[Client Receiver] " + line);
                      }
                  });
              })
              .join(); // Block until server closes the stream

        server.stop(0);
        System.out.println("\nStream finished.");
    }
}
