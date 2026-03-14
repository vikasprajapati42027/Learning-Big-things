package TestJava.Test205;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 205: Non-Blocking I/O Chat Server (NIO) ===\n");

        System.out.println("Old Java Servers required ONE Thread per Client.");
        System.out.println("Java NIO uses a 'Selector' (Event Loop) so ONE thread can handle THOUSANDS of clients!");
        System.out.println("This is exactly how Node.js and Netty work under the hood!\n");

        // We run the server in a separate thread so it doesn't block
        Thread serverThread = new Thread(() -> {
            try {
                // 1. Setup the Selector and Channels
                Selector selector = Selector.open();
                ServerSocketChannel serverSocket = ServerSocketChannel.open();
                
                serverSocket.bind(new InetSocketAddress("localhost", 8092));
                serverSocket.configureBlocking(false); // CRITICAL: Non-blocking mode!
                
                // Register the server socket to accept new connections
                serverSocket.register(selector, SelectionKey.OP_ACCEPT);

                System.out.println("[NIO Server] Event Loop Started on port 8092...");

                // 2. The Event Loop (Single Threaded!)
                // Run for 3 seconds then exit so the test finishes
                long startTime = System.currentTimeMillis();
                
                while (System.currentTimeMillis() - startTime < 3000) {
                    
                    // Block until at least one channel is ready for an operation
                    if (selector.select(500) == 0) continue; 
                    
                    Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                    
                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();
                        keys.remove(); // Prevent processing the same event twice
                        
                        if (!key.isValid()) continue;

                        if (key.isAcceptable()) {
                            // A new client is trying to connect!
                            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                            SocketChannel client = ssc.accept(); // Non-blocking accept
                            client.configureBlocking(false);
                            
                            // Tell the selector we want to know when this client sends data
                            client.register(selector, SelectionKey.OP_READ);
                            System.out.println("[NIO Server] Accepted new connection from " + client.getRemoteAddress());
                        } 
                        else if (key.isReadable()) {
                            // A connected client has sent us data!
                            SocketChannel client = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(256);
                            int bytesRead = client.read(buffer);
                            
                            if (bytesRead == -1) {
                                client.close(); // Client disconnected
                                System.out.println("[NIO Server] Client gracefully disconnected.");
                            } else {
                                String message = new String(buffer.array()).trim();
                                System.out.println("[NIO Server] Received Broadcast Message: " + message);
                                
                                // Broadcast back
                                String reply = "Server echoes: " + message + "\n";
                                client.write(ByteBuffer.wrap(reply.getBytes()));
                            }
                        }
                    }
                }
                serverSocket.close();
            } catch (Exception e) {}
        });
        
        serverThread.start();
        Thread.sleep(500); // Wait for server to boot

        // --- Client Simulation ---
        System.out.println("\n[Client] Connecting to NIO Server...");
        try (SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 8092))) {
            
            System.out.println("[Client] Sending message...");
            client.write(ByteBuffer.wrap("Hello Netty-like Server!".getBytes()));
            
            ByteBuffer responseBuffer = ByteBuffer.allocate(256);
            client.read(responseBuffer);
            System.out.println("[Client] " + new String(responseBuffer.array()).trim());
            
        } catch (Exception e) {}

        serverThread.join();
    }
}
