package Test_java_leanring.test7;

/**
 * test7 - Static: shared by all instances (one copy per class).
 */
public class Counter {
    private static int count = 0;
    private int id;

    public Counter() {
        count++;
        id = count;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
}
