class IdParent { String gen() { return "UUID"; } }
class CustomGen extends IdParent { @Override String gen() { return "ORD-123"; } }
public class IdGeneratorDemo {
    public static void main(String[] args) { System.out.println("ID: " + new CustomGen().gen()); }
}
