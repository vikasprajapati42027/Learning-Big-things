class DbLock { void lock() { System.out.println("DB Locked"); } }
class RowLock extends DbLock { }
public class PessimisticLockDemo {
    public static void main(String[] args) { new RowLock().lock(); }
}
