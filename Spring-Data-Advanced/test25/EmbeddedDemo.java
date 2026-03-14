class AddressParent { String type = "HOME"; }
class UserAddress extends AddressParent { }
public class EmbeddedDemo {
    public static void main(String[] args) { System.out.println("Address Type: " + new UserAddress().type); }
}
