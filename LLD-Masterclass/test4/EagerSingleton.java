public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {} // Private constructor
    public static EagerSingleton getInstance() {
        return instance;
    }
}
