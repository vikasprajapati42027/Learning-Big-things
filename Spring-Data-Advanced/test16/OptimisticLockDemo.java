class LockParent { int ver = 1; }
class ProductChild extends LockParent { }
public class OptimisticLockDemo {
    public static void main(String[] args) {
        System.out.println("Ver: " + new ProductChild().ver);
    }
}
