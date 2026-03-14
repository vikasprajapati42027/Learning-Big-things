class ActionParent { void exec() { System.out.println("Base Action"); } }
class ModifyAction extends ActionParent { @Override void exec() { System.out.println("UPDATE execution"); } }
public class ModifyingDemo {
    public static void main(String[] args) { new ModifyAction().exec(); }
}
