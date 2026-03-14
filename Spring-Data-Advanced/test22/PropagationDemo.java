class TxParent { String prop = "REQUIRED"; }
class TxChild extends TxParent { }
public class PropagationDemo {
    public static void main(String[] args) { System.out.println("Prop: " + new TxChild().prop); }
}
