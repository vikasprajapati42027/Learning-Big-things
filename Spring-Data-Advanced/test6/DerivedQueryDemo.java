interface UserRepo {
    void findByUsernameAndEmail(String u, String e);
}
public class DerivedQueryDemo {
    public static void main(String[] args) {
        System.out.println("Spring Data parses method names like 'findByX' automatically.");
    }
}
class BaseQuery { String greet() { return "Searching..."; } }
class SpecificQuery extends BaseQuery { }
public class DerivedQueryDemo {
    public static void main(String[] args) {
        System.out.println(new SpecificQuery().greet());
    }
}
