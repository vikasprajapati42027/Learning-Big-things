package Test_java_leanring.test114;

import java.lang.reflect.Field;

/** test114 - getDeclaredFields */
public class Main {
    int x = 5;
    public static void main(String[] args) throws Exception {
        System.out.println("=== test114: getDeclaredFields ===");
        for (Field f : Main.class.getDeclaredFields())
            System.out.println(f.getName());
    }
}
