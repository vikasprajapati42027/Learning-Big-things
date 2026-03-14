package Test_java_leanring.test113;

import java.lang.reflect.Method;

/** test113 - getMethod, invoke */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test113: Reflection invoke ===");
        Method m = String.class.getMethod("length");
        System.out.println(m.invoke("hello"));
    }
}
