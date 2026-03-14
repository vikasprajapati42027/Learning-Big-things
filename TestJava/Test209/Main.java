package TestJava.Test209;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 209: Heartbeat Mechanism (UDP) ===\n");

        System.out.println("In Microservices, servers send 'Heartbeats' to the Registry (e.g. Eureka)");
        System.out.println("every few seconds to say 'I am alive!' If it misses 3 beats, it's considered dead.\n");

        System.out.println("UDP is perfect for this because it's fast and we don't care if 1 packet drops.\n");

        // The Monitor (Eureka Server)
        Thread monitor = new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket(8095)) {
                socket.setSoTimeout(3000); // If no packet in 3 secs, consider node dead
                byte[] buffer = new byte[256];
                
                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    
                    try {
                        socket.receive(packet);
                        String msg = new String(packet.getData(), 0, packet.getLength());
                        System.out.println("[Monitor] Received: " + msg + " from " + packet.getPort());
                    } catch (java.net.SocketTimeoutException e) {
                        System.out.println("\n[Monitor] CRITICAL: Node has been silent for 3 seconds. Marking as Dead!");
                        break; // End test
                    }
                }
            } catch (Exception e) {}
        });
        monitor.start();

        // The Node (Microservice) sending heartbeats
        Thread node = new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket()) {
                InetAddress address = InetAddress.getByName("localhost");
                
                // Beat 3 times normally
                for (int i = 1; i <= 3; i++) {
                    String beat = "HEARTBEAT - Node-1 CPU: 12%";
                    byte[] data = beat.getBytes();
                    socket.send(new DatagramPacket(data, data.length, address, 8095));
                    Thread.sleep(1000); // 1 beat per second
                }
                
                System.out.println("\n[Node] *Simulating Server Crash* (Heartbeats stopping...)");
                // The thread naturally ends, stopping heartbeats!
                
            } catch (Exception e) {}
        });
        
        node.start();
        
        // Wait for the monitor to declare it dead and finish
        monitor.join();
    }
}
