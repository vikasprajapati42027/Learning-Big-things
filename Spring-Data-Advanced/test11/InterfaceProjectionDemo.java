interface BaseInfo { String getStatus(); }
class ParentInfo implements BaseInfo { public String getStatus() { return "ACTIVE"; } }
class ChildInfo extends ParentInfo { }
public class InterfaceProjectionDemo {
    public static void main(String[] args) {
        System.out.println("Status: " + new ChildInfo().getStatus());
    }
}
