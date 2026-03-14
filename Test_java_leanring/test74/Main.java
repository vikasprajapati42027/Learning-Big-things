package Test_java_leanring.test74;

/** test74 - Method reference static */
public class Main {
    static void say(String s) { System.out.println(s); }
    public static void main(String[] args) {
        System.out.println("=== test74: Method ref static ===");
        java.util.List.of("a", "b").forEach(Main::say);
    }
}
