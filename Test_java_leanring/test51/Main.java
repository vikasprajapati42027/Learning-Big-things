package Test_java_leanring.test51;

/** test51 - Record (compact canonical constructor) */
record Point(int x, int y) {}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test51: Record ===");
        Point p = new Point(1, 2);
        System.out.println(p.x() + " " + p.y() + " " + p);
    }
}
