package TestJava.Test117;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// TCP (Sockets) ensures exact order and delivery guarantee.
// UDP (DatagramSockets) is "fire and forget" - faster, but packets may be lost or arrive out of order!
// Used for Video Streaming, Gaming, VOIP.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== DatagramSocket (UDP Protocol) ===\n");

        int port = 8888;

        // Start UDP Server (Receiver)
        Thread receiver = new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket(port)) {
                System.out.println("[Receiver] Waiting for UDP packets on port " + port + "...");
                
                byte[] buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                
                // Blocks until a packet arrives
                socket.receive(packet); 
                
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("[Receiver] Received packet from: " + packet.getAddress() + ":" + packet.getPort());
                System.out.println("[Receiver] Payload: " + message);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        receiver.start();
        Thread.sleep(500);

        // Start UDP Client (Sender)
        System.out.println("[Sender] Preparing UDP payload...");
        try (DatagramSocket socket = new DatagramSocket()) {
            
            String msg = "Hello via UDP! No connection handshake needed!";
            byte[] buf = msg.getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            
            // Build the packet specifically targeted at the address and port
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            
            System.out.println("[Sender] Firing packet into the void...");
            socket.send(packet);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        receiver.join();
    }
}
