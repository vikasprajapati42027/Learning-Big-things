package Test_java_leanring.test66;

import java.util.Arrays;

/** test66 - Arrays.sort, copyOf */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test66: Arrays utils ===");
        int[] a = { 3, 1, 2 };
        Arrays.sort(a);
        int[] b = Arrays.copyOf(a, a.length);
        System.out.println(Arrays.toString(b));
    }
}
