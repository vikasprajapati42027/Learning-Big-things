import java.util.ArrayList;
import java.util.List;

public class FlyweightDemo {
    public static void main(String[] args) {
        List<Tree> forest = new ArrayList<>();

        // We want to plant 10,000 trees!
        // But we only have 2 types: Oak (Green) and Pine (DarkGreen)
        
        System.out.println("--- Planting 10,000 trees ---");
        for (int i = 0; i < 5000; i++) {
            forest.add(new Tree(i, i, TreeFactory.getTreeType("Oak", "Green")));
            forest.add(new Tree(i*2, i*2, TreeFactory.getTreeType("Pine", "DarkGreen")));
        }

        // Draw only a few to see results
        forest.get(0).draw();
        forest.get(1).draw();
        
        System.out.println("\nAll 10,000 trees are successfully pointing to only 2 Shared Objects!");
    }
}
