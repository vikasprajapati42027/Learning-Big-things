package Test_java_leanring.test34;

import java.util.Scanner;

/** test34 - Scanner (input) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test34: Scanner ===");
        Scanner sc = new Scanner("10 20");
        System.out.println(sc.nextInt() + sc.nextInt());
        sc.close();
    }
}
