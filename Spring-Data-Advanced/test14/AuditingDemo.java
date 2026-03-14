class AuditParent { long timestamp = System.currentTimeMillis(); }
class AuditChild extends AuditParent { }
public class AuditingDemo {
    public static void main(String[] args) {
        System.out.println("Audit Timestamp: " + new AuditChild().timestamp);
    }
}
