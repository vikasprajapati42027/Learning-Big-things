package Test_java_leanring.test52;

/** test52 - Default method in interface */
interface Greet {
    default void say() { System.out.println("Hello"); }
}
class Greeter implements Greet {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test52: Default method ===");
        new Greeter().say();
    }
}
