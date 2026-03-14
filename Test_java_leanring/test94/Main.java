package Test_java_leanring.test94;

/** test94 - Singleton */
class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {}
    static Singleton getInstance() { return INSTANCE; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== test94: Singleton ===");
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
    }
}
