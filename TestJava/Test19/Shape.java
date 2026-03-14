package TestJava.Test19;

public interface Shape {
    double getArea();
}

class Circle implements Shape {
    private final double radius;
    public Circle(double radius) { this.radius = radius; }
    public double getArea() { return Math.PI * radius * radius; }
    public double getRadius() { return radius; }
}

class Rectangle implements Shape {
    private final double width, height;
    public Rectangle(double width, double height) { this.width = width; this.height = height; }
    public double getArea() { return width * height; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}
