package Test_java_leanring.test112;

/** test112 - Class.forName (reflection) */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test112: Class.forName ===");
        Class<?> c = Class.forName("java.lang.String");
        System.out.println(c.getSimpleName());
    }
}
