package Test_java_leanring.test93;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test93: Builder ===");
        String r = new Builder().setA("x").setB("y").build();
        System.out.println(r);
    }
}
