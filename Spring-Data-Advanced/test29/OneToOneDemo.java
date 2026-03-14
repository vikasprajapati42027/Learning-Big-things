class SingleParent { String id = "UNIQUE"; }
class ProfileLink extends SingleParent { }
public class OneToOneDemo {
    public static void main(String[] args) { System.out.println("Link: " + new ProfileLink().id); }
}
