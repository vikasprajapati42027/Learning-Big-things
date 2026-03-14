import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<String>();
        bannedSites.add("facebook.com");
        bannedSites.add("instagram.com");
        bannedSites.add("gaming.com");
    }

    @Override
    public void connectTo(String host) throws Exception {
        if(bannedSites.contains(host.toLowerCase())) {
            throw new Exception("Access Denied to " + host + "! This is a work computer.");
        }
        // If not banned, pass the request to the real object
        internet.connectTo(host);
    }
}
