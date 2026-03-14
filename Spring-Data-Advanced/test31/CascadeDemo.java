class FlowParent { String effect = "PERSIST"; }
class SaveFlow extends FlowParent { }
public class CascadeDemo {
    public static void main(String[] args) { System.out.println("Cascade: " + new SaveFlow().effect); }
}
