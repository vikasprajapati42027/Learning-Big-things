package Test_java_leanring.test11;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test11: equals & hashCode ===");
        Box a = new Box(1);
        Box b = new Box(1);
        System.out.println(a.equals(b) + " " + (a.hashCode() == b.hashCode()));
    }
}
