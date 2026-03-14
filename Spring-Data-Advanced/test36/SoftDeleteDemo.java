class DeleteParent { boolean logic = true; }
class SoftDel extends DeleteParent { }
public class SoftDeleteDemo {
    public static void main(String[] args) { System.out.println("Soft Delete: " + new SoftDel().logic); }
}
