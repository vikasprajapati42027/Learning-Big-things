package TestJava.Test210;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

// A highly conceptual TCP Load Balancer (Like HAProxy or Nginx Proxy)
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 210: TCP Load Balancer Concept (Round Robin) ===\n");

        System.out.println("A Load Balancer sits on Port 80, accepts traffic, and silently forwards");
        System.out.println("the TCP stream to backend servers (Worker 1, Worker 2) using Round-Robin!\n");

        int[] backendPorts = {8097, 8098}; // Our two pretend workers
        
        // 1. Start two pretend Backend Servers
        for (int port : backendPorts) {
            new Thread(() -> {
                try (ServerSocket server = new ServerSocket(port)) {
                    server.setSoTimeout(3000);
                    Socket client = server.accept();
                    // Read whatever is sent and reply
                    client.getInputStream().read(new byte[100]); 
                    client.getOutputStream().write(("Response from Backend Worker on Port " + port).getBytes());
                    client.close();
                } catch (Exception e) {}
            }).start();
        }

        // 2. Start the Load Balancer on 8096
        AtomicInteger counter = new AtomicInteger(0);
        
        Thread loadBalancer = new Thread(() -> {
            try (ServerSocket lbServer = new ServerSocket(8096)) {
                lbServer.setSoTimeout(3000);
                
                // Accept 2 connections to demo load balancing
                for (int i = 0; i < 2; i++) {
                    Socket incomingClient = lbServer.accept();
                    
                    // Round Robin Logic!
                    int index = counter.getAndIncrement() % backendPorts.length;
                    int targetPort = backendPorts[index];
                    
                    System.out.println("[LoadBalancer] Routing request to Backend Port " + targetPort);
                    
                    // Create a connection to the backend
                    Socket backendConnection = new Socket("localhost", targetPort);
                    
                    // We proxy the traffic! (Read from client -> Write to Backend, Read from Backend -> Write to Client)
                    InputStream clientIn = incomingClient.getInputStream();
                    OutputStream backendOut = backendConnection.getOutputStream();
                    backendOut.write(clientIn.readNBytes(10)); // Forward fake request
                    
                    InputStream backendIn = backendConnection.getInputStream();
                    OutputStream clientOut = incomingClient.getOutputStream();
                    byte[] response = backendIn.readAllBytes();
                    clientOut.write(response); // Forward real response back to client!
                    
                    backendConnection.close();
                    incomingClient.close();
                }
            } catch (Exception e) {}
        });
        loadBalancer.start();

        Thread.sleep(500); // Give servers time to boot

        // 3. Simulated Clients connecting directly to the Load Balancer (not the backends!)
        try (Socket client1 = new Socket("localhost", 8096)) {
            client1.getOutputStream().write("Req 1_____".getBytes());
            System.out.println("Client 1 Received: " + new String(client1.getInputStream().readAllBytes()));
        }
        
        try (Socket client2 = new Socket("localhost", 8096)) {
            client2.getOutputStream().write("Req 2_____".getBytes());
            System.out.println("Client 2 Received: " + new String(client2.getInputStream().readAllBytes()));
        }
    }
}
