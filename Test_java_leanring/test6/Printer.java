package Test_java_leanring.test6;

/**
 * test6 - Method overloading: same method name, different parameters.
 */
public class Printer {
    public void print(String msg) {
        System.out.println("String: " + msg);
    }

    public void print(int n) {
        System.out.println("int: " + n);
    }

    public void print(String msg, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(msg);
        }
    }
}
