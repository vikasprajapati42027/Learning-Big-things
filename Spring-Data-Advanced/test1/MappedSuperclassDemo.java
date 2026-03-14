class BaseAudit { protected String createdBy = "System"; }
class UserEntity extends BaseAudit { 
    String name; 
    public UserEntity(String n) { this.name = n; }
    public void print() { System.out.println(name + " by " + createdBy); }
}
public class MappedSuperclassDemo {
    public static void main(String[] args) {
        new UserEntity("Vikas").print();
    }
}
