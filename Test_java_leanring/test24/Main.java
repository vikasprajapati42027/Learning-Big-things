package Test_java_leanring.test24;

/** test24 - Enum with fields */
enum Size {
    S(1), M(2), L(3);
    private final int code;
    Size(int code) { this.code = code; }
    int getCode() { return code; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test24: Enum with fields ===");
        System.out.println(Size.M.getCode());
    }
}
