class FetchParent { String type = "LAZY"; }
class ConfigFetch extends FetchParent { }
public class FetchDemo {
    public static void main(String[] args) { System.out.println("Fetch: " + new ConfigFetch().type); }
}
