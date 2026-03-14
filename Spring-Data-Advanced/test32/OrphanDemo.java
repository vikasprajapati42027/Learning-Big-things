class CleanParent { boolean autoDelete = true; }
class OrphanClean extends CleanParent { }
public class OrphanDemo {
    public static void main(String[] args) { System.out.println("Clean: " + new OrphanClean().autoDelete); }
}
