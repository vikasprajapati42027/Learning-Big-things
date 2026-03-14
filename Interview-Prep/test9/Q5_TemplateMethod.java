/**
 * INTERVIEWER: Explain Template Method Pattern.
 * CANDIDATE: It defines the skeleton of an algorithm in a method, deferring some steps to subclasses.
 */
abstract class Game {
    abstract void start();
    abstract void end();
    // Template Method
    public final void play() {
        start();
        System.out.println("Playing...");
        end();
    }
}
class Cricket extends Game {
    void start() { System.out.println("Cricket Game Started"); }
    void end() { System.out.println("Cricket Game Finished"); }
}
public class Q5_TemplateMethod {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
    }
}
