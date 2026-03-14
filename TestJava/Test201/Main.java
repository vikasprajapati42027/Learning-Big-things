package TestJava.Test201;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 201: WebSockets Server Concept (Handshake) ===\n");

        System.out.println("WebSockets upgrade a standard HTTP connection to a persistent TCP stream!");
        System.out.println("To do this, the server must read the client's 'Sec-WebSocket-Key', hash it");
        System.out.println("with a magic string, and send it back as 'Sec-WebSocket-Accept'.\n");

        // We run the server in a separate thread so it doesn't block
        new Thread(() -> {
            try (ServerSocket server = new ServerSocket(8088)) {
                System.out.println("WebSocket Server listening on port 8088...");
                
                // Set a timeout so the script eventually ends for automated testing
                server.setSoTimeout(3000); 
                
                Socket client = server.accept();
                System.out.println("Client connected!");

                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();
                Scanner scanner = new Scanner(in, "UTF-8");

                // 1. Read HTTP Headers
                String data = scanner.useDelimiter("\\r\\n\\r\\n").next();
                
                // 2. Extract the Sec-WebSocket-Key
                String clientKey = "";
                for (String line : data.split("\\r\\n")) {
                    if (line.startsWith("Sec-WebSocket-Key:")) {
                        clientKey = line.split(":")[1].trim();
                        break;
                    }
                }

                if (!clientKey.isEmpty()) {
                    System.out.println("Received Key: " + clientKey);

                    // 3. Compute Sec-WebSocket-Accept
                    // Magic string defined by RFC 6455
                    String magicString = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
                    byte[] hashed = MessageDigest.getInstance("SHA-1").digest((clientKey + magicString).getBytes("UTF-8"));
                    String acceptKey = Base64.getEncoder().encodeToString(hashed);

                    // 4. Send the Upgrade Response!
                    String response = "HTTP/1.1 101 Switching Protocols\r\n"
                            + "Connection: Upgrade\r\n"
                            + "Upgrade: websocket\r\n"
                            + "Sec-WebSocket-Accept: " + acceptKey + "\r\n\r\n";
                    
                    out.write(response.getBytes("UTF-8"));
                    System.out.println("Handshake complete! Connection upgraded to WebSocket!");
                }
                
                client.close();

            } catch (Exception e) {
                // Ignore timeout Exception for automated testing
            }
        }).start();

        // Let the server start
        Thread.sleep(500);

        // Simulated Client connecting
        System.out.println("[Client] Connecting to ws://localhost:8088 ...");
        try (Socket socket = new Socket("localhost", 8088)) {
            OutputStream out = socket.getOutputStream();
            String fakeHttpReq = "GET /chat HTTP/1.1\r\n" +
                                 "Host: localhost:8088\r\n" +
                                 "Upgrade: websocket\r\n" +
                                 "Connection: Upgrade\r\n" +
                                 "Sec-WebSocket-Key: dGhlIHNhbXBsZSBub25jZQ==\r\n" +
                                 "Sec-WebSocket-Version: 13\r\n\r\n";
            
            System.out.println("[Client] Sending Handshake request...");
            out.write(fakeHttpReq.getBytes());
            out.flush();
            
            // Read response
            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int read = in.read(buffer);
            System.out.println("\n[Client] Server Response:");
            System.out.println(new String(buffer, 0, read));
        }

        Thread.sleep(500); // Give threads time to finish printing
    }
}
