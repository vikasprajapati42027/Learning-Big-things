class RouteParent { String master = "WRITE"; }
class SlaveRoute extends RouteParent { String slave = "READ"; }
public class RwSplitDemo {
    public static void main(String[] args) { System.out.println("Router: Master-Slave Split Configured"); }
}
