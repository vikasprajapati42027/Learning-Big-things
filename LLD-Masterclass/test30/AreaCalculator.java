import java.util.List;

public class AreaCalculator {
    public double sum(List<Shape> shapes) {
        double total = 0;
        for (Shape s : shapes) {
            total += s.calculateArea();
        }
        return total;
    }
}
