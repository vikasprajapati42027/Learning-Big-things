package Test_java_leanring.test46;

/** test46 - Bounded type parameter */
public class Main {
    static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
    public static void main(String[] args) {
        System.out.println("=== test46: Bounded generic ===");
        System.out.println(max(3, 5));
        System.out.println(max("a", "z"));
    }
}
