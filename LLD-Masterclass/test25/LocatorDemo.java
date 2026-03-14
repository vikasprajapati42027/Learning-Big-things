public class LocatorDemo {
    public static void main(String[] args) {
        Service s1 = ServiceLocator.getService("EmailService"); // Looks it up
        s1.execute();

        Service s2 = ServiceLocator.getService("EmailService"); // Returns from cache
        s2.execute();
    }
}
