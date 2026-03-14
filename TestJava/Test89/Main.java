package TestJava.Test89;

import java.util.concurrent.Exchanger;

// Exchanger acts as a synchronization point where exactly TWO threads 
// meet to safely swap data with each other!
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Exchanger (Thread Data Swapping) ===\n");

        Exchanger<String> messageExchanger = new Exchanger<>();

        Thread serverThread = new Thread(() -> {
            try {
                String responseData = "200 OK - Data Payload [Server]";
                System.out.println("[Server] Arrived with: " + responseData);
                System.out.println("[Server] Waiting for Client...");
                
                // Blocks here until the other thread also calls exchange()
                String dataFromClient = messageExchanger.exchange(responseData);
                
                System.out.println("[Server] Received from swap: " + dataFromClient);
            } catch (InterruptedException e) {}
        });

        Thread clientThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Client takes a second to generate its request
                String requestData = "GET /api/users [Client]";
                System.out.println("\n[Client] Arrived with: " + requestData);
                
                String dataFromServer = messageExchanger.exchange(requestData);
                
                System.out.println("[Client] Received from swap: " + dataFromServer);
            } catch (InterruptedException e) {}
        });

        serverThread.start();
        clientThread.start();
        
        serverThread.join();
        clientThread.join();
    }
}
