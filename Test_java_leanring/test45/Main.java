package Test_java_leanring.test45;

/** test45 - Generic method */
public class Main {
    static <T> T identity(T t) { return t; }
    public static void main(String[] args) {
        System.out.println("=== test45: Generic method ===");
        System.out.println(identity("hi"));
        System.out.println(identity(42));
    }
}
