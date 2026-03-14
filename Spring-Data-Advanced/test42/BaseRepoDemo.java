interface BaseInterface { void common(); }
class ParentImplementation implements BaseInterface { public void common() { System.out.println("Shared logic"); } }
class ChildImplementation extends ParentImplementation { }
public class BaseRepoDemo {
    public static void main(String[] args) { new ChildImplementation().common(); }
}
