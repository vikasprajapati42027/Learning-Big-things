package TestJava.Test119;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== HttpClient (Asynchronous API) ===\n");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
                .GET()
                .build();

        System.out.println("Dispatched Async GET request...");

        // .sendAsync returns a CompletableFuture IMMEDIATELY.
        // It does not block the main thread!
        CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // We can attach callbacks to run when the response finally arrives
        futureResponse.thenApply(HttpResponse::body)
                      .thenAccept(body -> {
                          System.out.println("\n>>> [ASYNC CALLBACK] Data Arrived!");
                          System.out.println(">>> " + body.split("\n")[1]); // print just the name line
                      })
                      .exceptionally(ex -> {
                          System.out.println(">>> Error occurred: " + ex.getMessage());
                          return null;
                      });

        System.out.println("Main thread is NOT blocked. Doing other work while HTTP request is in flight...");
        
        // Wait long enough for the async callback to trigger
        Thread.sleep(2000); 
    }
}
