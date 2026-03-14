package TestJava.Test116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Legacy Socket & ServerSocket Tutorial ===\n");

        int port = 8085;

        // 1. Start the Server in a background thread
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("[Server] Listening on port " + port + "...");
                
                // .accept() blocks until a client connects!
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                     
                    System.out.println("[Server] Client Connected!");
                    
                    // Read data from client
                    String inputLine = in.readLine();
                    System.out.println("[Server] Received from Client: " + inputLine);
                    
                    // Send response back
                    out.println("Hello Client! Acknowledged: " + inputLine);
                }
            } catch (Exception e) {
                System.out.println("[Server] Exception: " + e.getMessage());
            }
        });

        serverThread.start();
        Thread.sleep(500); // Give server time to start up

        // 2. Start the Client
        System.out.println("[Client] Connecting to server...");
        try (Socket socket = new Socket("localhost", port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
             
            // Send data to Server
            System.out.println("[Client] Sending greeting...");
            out.println("Ping from Client!");
            
            // Wait for Server response
            String response = in.readLine();
            System.out.println("[Client] Received from Server: " + response);
            
        } catch (Exception e) {
            System.out.println("[Client] Exception: " + e.getMessage());
        }

        serverThread.join();
        System.out.println("\nSocket Demo Complete. Note: NIO (Test98) is preferred for high-concurrency servers.");
    }
}
