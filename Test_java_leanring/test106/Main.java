package Test_java_leanring.test106;

import java.nio.ByteBuffer;

/** test106 - ByteBuffer */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test106: ByteBuffer ===");
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.put((byte) 1);
        buf.flip();
        System.out.println(buf.get());
    }
}
