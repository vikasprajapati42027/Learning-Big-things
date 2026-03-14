abstract class Filter { abstract void apply(); }
class NameFilter extends Filter { void apply() { System.out.println("Filtering by Name"); } }
public class SpecificationDemo {
    public static void main(String[] args) {
        new NameFilter().apply();
    }
}
