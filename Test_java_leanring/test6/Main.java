package Test_java_leanring.test6;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test6: Method overloading ===");

        Printer p = new Printer();
        p.print("Hello");
        p.print(42);
        p.print("Hi", 2);
    }
}
