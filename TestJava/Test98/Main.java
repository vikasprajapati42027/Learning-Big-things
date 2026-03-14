package TestJava.Test98;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

// A Selector allows a SINGLE thread to examine multiple Channels 
// to see if they are ready for reading, writing, or accepting connections.
// This is non-blocking I/O (Async), the core of high-performance servers like Netty/Node.js!
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== NIO Selectors (Non-Blocking I/O) ===\n");

        System.out.println("Starting a quick non-blocking server on port 9090...");
        
        // 1. Open a ServerSocketChannel and configure it to be NON-BLOCKING
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(9090));
        serverChannel.configureBlocking(false);

        // 2. Open a Selector
        Selector selector = Selector.open();

        // 3. Register the server channel with the selector for "ACCEPT" events
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        // Simulation: Start a client thread to connect right away so we have something to select!
        new Thread(() -> {
            try {
                Thread.sleep(500); // Wait for server to set up
                SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 9090));
                client.write(ByteBuffer.wrap("Hello non-blocking world!".getBytes()));
                client.close();
            } catch (Exception e) {}
        }).start();

        // 4. The Event Loop 
        System.out.println("Server is listening... (Will shutdown after 1 connection for this test)");
        boolean running = true;
        
        while (running) {
            // Block until at least one channel is ready for the events we registered for
            selector.select();
            
            // Get the keys representing the ready channels
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove(); // VERY IMPORTANT: Remove key from set so we don't process it twice
                
                if (key.isAcceptable()) {
                    // A connection was accepted
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    
                    System.out.println("Accepted connection from: " + client.getRemoteAddress());
                    
                    // Register the NEW client channel for "READ" events
                    client.register(selector, SelectionKey.OP_READ);
                    
                } else if (key.isReadable()) {
                    // Data is ready to be read from a client
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    int bytesRead = client.read(buffer);
                    
                    if (bytesRead > 0) {
                        buffer.flip();
                        String message = new String(buffer.array(), 0, bytesRead);
                        System.out.println("Received message: " + message);
                        running = false; // We got our test message, stop the server loop
                        client.close();
                    }
                }
            }
        }
        
        serverChannel.close();
        System.out.println("\nSelector demonstration complete.");
    }
}
