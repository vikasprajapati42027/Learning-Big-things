/**
 * Interviewer: Factory Method vs Simple Factory?
 */
interface Shape { void draw(); }
class Circle implements Shape { public void draw() {} }
class ShapeFactory {
    public Shape getShape(String type) {
        if(type.equals("CIRCLE")) return new Circle();
        return null;
    }
}
public class Q2_Factory_Method { }
