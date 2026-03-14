package Test_java_leanring.test119;

/** test119 - String isBlank, lines */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test119: isBlank lines ===");
        System.out.println("   ".isBlank());
        "a\nb".lines().forEach(System.out::println);
    }
}
