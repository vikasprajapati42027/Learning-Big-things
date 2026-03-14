package Test_java_leanring.test81;

import java.util.BitSet;

/** test81 - BitSet */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test81: BitSet ===");
        BitSet bs = new BitSet();
        bs.set(0); bs.set(2);
        System.out.println(bs.get(0) + " " + bs.get(1));
    }
}
