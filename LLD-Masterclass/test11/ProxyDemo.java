public class ProxyDemo {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        
        try {
            internet.connectTo("google.com");
            internet.connectTo("facebook.com"); // This will fail
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
