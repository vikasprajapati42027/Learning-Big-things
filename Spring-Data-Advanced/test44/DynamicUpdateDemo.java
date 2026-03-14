class UpdateParent { boolean checkDirty = true; }
class SmartUpdate extends UpdateParent { }
public class DynamicUpdateDemo {
    public static void main(String[] args) { System.out.println("Dirty Check: " + new SmartUpdate().checkDirty); }
}
