package Test_java_leanring.test75;

/** test75 - Method reference instance (String::toUpperCase) */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test75: Method ref instance ===");
        java.util.List.of("a", "b").stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
