package Test_java_leanring.test150;

/** test150 - Recap: Record, var, sealed, pattern matching */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test150: Recap (Record, var, pattern) ===");
        record Pair(int a, int b) {}
        var p = new Pair(1, 2);
        System.out.println(p.a() + p.b());
        Object o = "hi";
        if (o instanceof String s) System.out.println(s.toUpperCase());
    }
}
