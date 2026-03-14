public class SingletonDemo {
    public static void main(String[] args) {
        ThreadSafeSingleton s1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton s2 = ThreadSafeSingleton.getInstance();
        System.out.println("Are both instances same? " + (s1 == s2));
        
        EnumSingleton.INSTANCE.doSomething();
    }
}
