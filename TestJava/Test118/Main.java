package TestJava.Test118;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

// Introduced in Java 11, the new HttpClient completely replaces the ancient and clunky HttpURLConnection!
public class Main {
    public static void main(String[] args) {
        System.out.println("=== HttpClient (Synchronous API) ===\n");

        // 1. Create a Client
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // 2. Build a Request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .header("Accept", "application/json")
                .GET() // We can also use POST, PUT, DELETE, etc.
                .build();

        System.out.println("Sending GET request to jsonplaceholder API...");

        // 3. Send the request Synchronously (Blocks until we get the full response)
        try {
            // We tell it to treat the response body as a simple String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("\nStatus Code: " + response.statusCode());
            System.out.println("Headers: " + response.headers().map());
            System.out.println("\nResponse Body (JSON):");
            System.out.println(response.body());
            
        } catch (Exception e) {
            System.out.println("Request Failed: " + e.getMessage());
        }
    }
}
