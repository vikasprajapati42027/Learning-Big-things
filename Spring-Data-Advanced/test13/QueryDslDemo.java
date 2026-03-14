class QBase { String path = "root"; }
class QUser extends QBase { String field = "username"; }
public class QueryDslDemo {
    public static void main(String[] args) {
        QUser user = new QUser();
        System.out.println("Querying " + user.path + "." + user.field);
    }
}
