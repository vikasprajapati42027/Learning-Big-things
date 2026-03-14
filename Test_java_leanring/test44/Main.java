package Test_java_leanring.test44;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test44: Generics ===");
        Box<String> b = new Box<>();
        b.set("hello");
        System.out.println(b.get());
    }
}
