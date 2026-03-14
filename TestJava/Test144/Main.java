package TestJava.Test144;

import java.util.ArrayList;
import java.util.List;

// 1. The Strategy Interface
interface CompressionStrategy {
    void compressFiles(List<String> files);
}

// 2. Concrete Strategies
class ZipCompressionStrategy implements CompressionStrategy {
    public void compressFiles(List<String> files) {
        System.out.println("Compressing " + files.size() + " files into a .ZIP archive (Fast, standard compression).");
    }
}

class RarCompressionStrategy implements CompressionStrategy {
    public void compressFiles(List<String> files) {
        System.out.println("Compressing " + files.size() + " files into a .RAR archive (Slow, high compression).");
    }
}

// 3. The Context Class
class CompressionContext {
    private CompressionStrategy strategy;

    // We can swap the Strategy at runtime!
    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    // The Context delegates the work to the Strategy object
    public void createArchive(List<String> files) {
        if (strategy == null) {
            System.out.println("Error: Strategy not set.");
            return;
        }
        strategy.compressFiles(files);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Design Pattern: Strategy ===\n");

        System.out.println("The Strategy pattern defines a family of algorithms and makes them interchangeable.");
        System.out.println("It lets the algorithm vary independently from the clients that use it.\n");

        CompressionContext ctx = new CompressionContext();
        
        List<String> myFiles = new ArrayList<>(List.of("doc1.pdf", "image2.png", "data.json"));

        // Use ZIP Strategy
        ctx.setCompressionStrategy(new ZipCompressionStrategy());
        ctx.createArchive(myFiles);

        System.out.println("--- User changed settings to High Compression ---");

        // Swap to RAR Strategy dynamically at runtime!
        ctx.setCompressionStrategy(new RarCompressionStrategy());
        ctx.createArchive(myFiles);
    }
}
