package Test_java_leanring.test116;

import java.math.BigInteger;

/** test116 - BigInteger */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test116: BigInteger ===");
        BigInteger a = new BigInteger("1000000000000");
        System.out.println(a.add(BigInteger.ONE));
    }
}
