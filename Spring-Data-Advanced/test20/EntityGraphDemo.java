class GraphParent { String load = "EAGER"; }
class UserGraph extends GraphParent { }
public class EntityGraphDemo {
    public static void main(String[] args) {
        System.out.println("Load Strategy: " + new UserGraph().load);
    }
}
