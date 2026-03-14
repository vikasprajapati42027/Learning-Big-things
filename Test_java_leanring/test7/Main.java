package Test_java_leanring.test7;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test7: Static members ===");

        System.out.println("Count before: " + Counter.getCount());
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println("Count after 2 objects: " + Counter.getCount());
        System.out.println("c1.id=" + c1.getId() + " c2.id=" + c2.getId());
    }
}
