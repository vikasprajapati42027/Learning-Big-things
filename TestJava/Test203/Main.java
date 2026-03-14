package TestJava.Test203;

import java.nio.ByteBuffer;
import java.util.Arrays;

// A manual simulation of what Google Protocol Buffers (gRPC) does under the hood!
record User(int id, String name, boolean isActive) {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 203: Protocol Buffers (gRPC Format) Concept ===\n");

        System.out.println("JSON takes up a lot of space because it uses text keys like '\"id\": 123'.");
        System.out.println("Protobuf serializes data into compact BINARY arrays based on an agreed schema.");
        System.out.println("gRPC uses this for lightning-fast microservice communication!\n");

        User myUser = new User(1054, "Alice", true);
        System.out.println("Original Object: " + myUser);

        // --- 1. Serialization (JSON vs Protobuf) ---
        String json = "{\"id\":1054,\"name\":\"Alice\",\"isActive\":true}";
        byte[] jsonBytes = json.getBytes();
        System.out.println("JSON Size: " + jsonBytes.length + " bytes");

        // Protobuf Manual Serialization
        // Schema Agreement (Client and Server know this!):
        // 4 bytes for ID (int) + 1 byte for Name Length + X bytes for Name String + 1 byte for boolean
        ByteBuffer buffer = ByteBuffer.allocate(100); 
        
        buffer.putInt(myUser.id()); // 4 bytes! No matter if number is 1 or 1,000,000
        
        byte[] nameBytes = myUser.name().getBytes();
        buffer.put((byte) nameBytes.length); // 1 byte indicating how long the string is
        buffer.put(nameBytes); // The actual characters
        
        buffer.put((byte) (myUser.isActive() ? 1 : 0)); // 1 byte for boolean
        
        // Finalize the binary array
        buffer.flip();
        byte[] protoBytes = new byte[buffer.limit()];
        buffer.get(protoBytes);
        
        System.out.println("Binary Size: " + protoBytes.length + " bytes (Much smaller!)");
        System.out.print("Binary Payload: ");
        for (byte b : protoBytes) System.out.printf("%02X ", b);
        System.out.println("\n");

        // --- 2. Deserialization ---
        System.out.println("Server received Binary bytes...");
        ByteBuffer reader = ByteBuffer.wrap(protoBytes);
        
        int parsedId = reader.getInt();
        
        int nameLength = reader.get();
        byte[] parsedNameBytes = new byte[nameLength];
        reader.get(parsedNameBytes);
        String parsedName = new String(parsedNameBytes);
        
        boolean parsedActive = reader.get() == 1;

        User reconstructedObject = new User(parsedId, parsedName, parsedActive);
        System.out.println("Reconstructed Object: " + reconstructedObject);
    }
}
