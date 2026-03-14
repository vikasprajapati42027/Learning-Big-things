public class ServiceLocator {
    private static Cache cache = new Cache();

    public static Service getService(String jndiName) {
        Service service = cache.getService(jndiName);
        if (service != null) return service;

        // If not in cache, "lookup" (mocking a lookup)
        if (jndiName.equalsIgnoreCase("EmailService")) {
            System.out.println("Looking up and creating Message Service...");
            Service s1 = new EmailService();
            cache.addService(s1);
            return s1;
        }
        return null;
    }
}
