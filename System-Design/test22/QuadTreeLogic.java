import java.util.*;

class Point { double x, y; }

public class QuadTree {
    // A simplifiedQuadTree divide logic
    // If a node has more than 4 points, split it into 4 children (NW, NE, SW, SE)
    // This allows O(log N) search for "Who is near me?"
    List<Point> points = new ArrayList<>();
    QuadTree[] children = null;
    
    public void insert(Point p) {
        if (points.size() < 4) {
            points.add(p);
        } else {
            if (children == null) split();
            // find which child p belongs to and insert recursively
        }
    }
    
    private void split() { /* create 4 child nodes based on boundaries */ }
}
