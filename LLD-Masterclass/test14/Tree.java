// This class stores the Unique state (Coordinates)
public class Tree {
    private int x;
    private int y;
    private TreeType type; // Shared reference

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
