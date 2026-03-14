class DbParent { String url = "jdbc:primary"; }
class SecondaryDb extends DbParent { String url = "jdbc:secondary"; }
public class MultiDbDemo {
    public static void main(String[] args) { System.out.println("DB: " + new SecondaryDb().url); }
}
