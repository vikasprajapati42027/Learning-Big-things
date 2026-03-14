/**
 * Interviewer: What is the Prototype Pattern?
 * Candidate: It's used to create new objects by copying an existing object (the prototype). 
 * Useful when object creation is expensive.
 */
import java.util.*;

abstract class Shape implements Cloneable {
    private String id;
    protected String type;
    abstract void draw();

    public Object clone() {
        Object clone = null;
        try { clone = super.clone(); } catch (CloneNotSupportedException e) { e.printStackTrace(); }
        return clone;
    }
    public void setId(String id) { this.id = id; }
    public String getType() { return type; }
}

class Rectangle extends Shape {
    public Rectangle() { type = "Rectangle"; }
    @Override public void draw() { System.out.println("Drawing Rectangle"); }
}

public class Q4_Prototype_Pattern {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Rectangle clonedRect = (Rectangle) rect.clone();
        System.out.println("Clone Type: " + clonedRect.getType());
    }
}
