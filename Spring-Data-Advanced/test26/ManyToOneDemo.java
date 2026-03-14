class RelationParent { String name = "MANY_TO_ONE"; }
class DeptRelation extends RelationParent { }
public class ManyToOneDemo {
    public static void main(String[] args) { System.out.println("Rel: " + new DeptRelation().name); }
}
