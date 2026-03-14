interface ProfileView { String getName(); }
class UserParent implements ProfileView { public String getName() { return "Vikas"; } }
class UserChild extends UserParent { }
public class ProjectionDemo {
    public static void main(String[] args) {
        System.out.println("Projected Name: " + new UserChild().getName());
    }
}
