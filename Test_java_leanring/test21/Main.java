package Test_java_leanring.test21;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test21: Inner class ===");
        Outer.Inner i = new Outer().new Inner();
        i.show();
    }
}
