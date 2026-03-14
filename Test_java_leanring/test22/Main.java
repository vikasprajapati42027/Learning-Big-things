package Test_java_leanring.test22;

/** test22 - Anonymous class */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test22: Anonymous class ===");
        Greeter g = new Greeter() {
            @Override
            public void greet() { System.out.println("Hello from anonymous"); }
        };
        g.greet();
    }
}
