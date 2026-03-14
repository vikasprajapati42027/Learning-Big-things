/**
 * Interviewer: Double-Checked Locking in Singleton?
 */
class FastSingleton {
    private static volatile FastSingleton instance;
    public static FastSingleton getInstance() {
        if (instance == null) {
            synchronized (FastSingleton.class) {
                if (instance == null) instance = new FastSingleton();
            }
        }
        return instance;
    }
}
public class Q6_Singleton_Optimization { }
