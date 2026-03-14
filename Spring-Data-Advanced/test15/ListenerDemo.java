class BaseListener { void onEvent() { System.out.println("Base event"); } }
class SaveListener extends BaseListener { @Override void onEvent() { System.out.println("Save event"); } }
public class ListenerDemo {
    public static void main(String[] args) { new SaveListener().onEvent(); }
}
