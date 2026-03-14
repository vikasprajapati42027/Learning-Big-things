// This is the Flyweight. It stores shared state (Name, Color, Texture).
public class TreeType {
    private String name;
    private String color;

    public TreeType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " " + name + " at coord (" + x + "," + y + ")");
    }
}
