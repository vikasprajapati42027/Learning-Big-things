package Test_java_leanring.test15;

import Test_java_leanring.test1.Student;

/** test15 - instanceof and getClass() */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test15: instanceof & getClass ===");
        Object o = new Student("A", 1);
        System.out.println(o instanceof Student);
        System.out.println(o.getClass().getSimpleName());
    }
}
