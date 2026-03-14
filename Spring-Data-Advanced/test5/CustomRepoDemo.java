interface BaseRepo { void save(); }
class CustomRepoImpl implements BaseRepo { public void save() { System.out.println("Custom Logic"); } }
public class CustomRepoDemo {
    public static void main(String[] args) { new CustomRepoImpl().save(); }
}
