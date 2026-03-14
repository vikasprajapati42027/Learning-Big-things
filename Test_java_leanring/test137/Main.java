package Test_java_leanring.test137;

import java.util.StringTokenizer;

/** test137 - StringTokenizer */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test137: StringTokenizer ===");
        StringTokenizer st = new StringTokenizer("a b c");
        while (st.hasMoreTokens()) System.out.println(st.nextToken());
    }
}
