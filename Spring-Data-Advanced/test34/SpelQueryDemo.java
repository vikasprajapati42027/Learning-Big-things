class SpelParent { String expr = "#{...}"; }
class DynamicQuery extends SpelParent { }
public class SpelQueryDemo {
    public static void main(String[] args) { System.out.println("Expr: " + new DynamicQuery().expr); }
}
