class ListParent { int count = 0; }
class ChildList extends ListParent { }
public class OneToManyDemo {
    public static void main(String[] args) { System.out.println("Children: " + new ChildList().count); }
}
