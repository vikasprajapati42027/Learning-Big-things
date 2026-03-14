public abstract class Game {
    // These methods must be implemented by subclasses
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // The Template Method (final means it cannot be changed!)
    public final void play() {
        // Step 1: Initialize
        initialize();
        // Step 2: Play
        startPlay();
        // Step 3: End
        endPlay();
    }
}
