class JpqlParent { String query = "SELECT u FROM User u"; }
class JpqlChild extends JpqlParent { }
public class JpqlDemo {
    public static void main(String[] args) {
        System.out.println("Executing: " + new JpqlChild().query);
    }
}
