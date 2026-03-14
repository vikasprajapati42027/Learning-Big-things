package Test_java_leanring.test53;

/** test53 - Static method in interface */
interface Util {
    static int add(int a, int b) { return a + b; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test53: Static in interface ===");
        System.out.println(Util.add(2, 3));
    }
}
