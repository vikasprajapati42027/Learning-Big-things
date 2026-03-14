package Test_java_leanring.test20;

/** test20 - varargs */
public class Main {
    static void printAll(String... args) {
        for (String s : args) System.out.println(s);
    }
    public static void main(String[] args) {
        System.out.println("=== test20: varargs ===");
        printAll("A", "B", "C");
    }
}
