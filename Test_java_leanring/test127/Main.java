package Test_java_leanring.test127;

/** test127 - @Deprecated */
public class Main {
    @Deprecated
    static void oldMethod() {}
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        System.out.println("=== test127: @Deprecated ===");
        oldMethod();
    }
}
