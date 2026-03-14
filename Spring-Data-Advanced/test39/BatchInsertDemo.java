class BatchParent { int limit = 50; }
class InsertBatch extends BatchParent { }
public class BatchInsertDemo {
    public static void main(String[] args) { System.out.println("Batch size: " + new InsertBatch().limit); }
}
