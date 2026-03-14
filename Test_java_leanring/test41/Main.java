package Test_java_leanring.test41;

/** test41 - throw and throws */
public class Main {
    static int div(int a, int b) throws IllegalArgumentException {
        if (b == 0) throw new IllegalArgumentException("b is 0");
        return a / b;
    }
    public static void main(String[] args) {
        System.out.println("=== test41: throw/throws ===");
        try {
            System.out.println(div(10, 2));
            div(10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
