package Test_java_leanring.test95;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test95: Immutable ===");
        Immutable i = new Immutable(42);
        System.out.println(i.getValue());
    }
}
