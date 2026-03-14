class SQLParent { String raw = "SELECT * FROM users"; }
class SQLChild extends SQLParent { }
public class NativeQueryDemo {
    public static void main(String[] args) {
        System.out.println("Running Native: " + new SQLChild().raw);
    }
}
