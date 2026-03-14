class HintParent { String key = "cacheable"; }
class SlowQueryHint extends HintParent { String key = "timeout"; }
public class QueryHintDemo {
    public static void main(String[] args) { System.out.println("Hint: " + new SlowQueryHint().key); }
}
