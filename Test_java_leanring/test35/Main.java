package Test_java_leanring.test35;

import java.util.Random;

/** test35 - Random */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test35: Random ===");
        Random r = new Random(42);
        System.out.println(r.nextInt(10) + " " + r.nextDouble());
    }
}
