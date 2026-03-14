package Test_java_leanring.test89;

/** test89 - Recursion */
public class Main {
    static int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }
    public static void main(String[] args) {
        System.out.println("=== test89: Recursion ===");
        System.out.println(fact(5));
    }
}
