class SliceParent { boolean hasNext = true; }
class DataSlice extends SliceParent { }
public class SliceDemo {
    public static void main(String[] args) {
        System.out.println("Has Next: " + new DataSlice().hasNext);
    }
}
