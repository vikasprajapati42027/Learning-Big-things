class ModeParent { boolean readOnly = true; }
class ModeChild extends ModeParent { }
public class ReadOnlyDemo {
    public static void main(String[] args) { System.out.println("ReadOnly: " + new ModeChild().readOnly); }
}
