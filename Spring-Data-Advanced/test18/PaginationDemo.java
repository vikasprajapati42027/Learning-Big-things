class PageParent { int size = 10; }
class UserPage extends PageParent { }
public class PaginationDemo {
    public static void main(String[] args) {
        System.out.println("Page size: " + new UserPage().size);
    }
}
