package Test_java_leanring.test21;

/** test21 - Nested (inner) class */
public class Outer {
    private int x = 1;
    class Inner {
        void show() { System.out.println("Inner " + x); }
    }
}
