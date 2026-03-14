public class CustomerFactory {
    public static final String[] names = {"Vikas", "Amit", "Rahul"};

    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        // Instead of returning NULL, return a Null Object!
        return new NullCustomer();
    }
}
