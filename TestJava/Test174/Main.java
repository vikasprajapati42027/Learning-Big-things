package TestJava.Test174;

// 1. The State Interface
interface State {
    void doAction(Context context);
}

// 2. Concrete States
class PlayState implements State {
    public void doAction(Context context) {
        System.out.println("Media Player is now PLAYING.");
        context.setState(this);
    }
    public String toString() { return "Play State"; }
}

class PauseState implements State {
    public void doAction(Context context) {
        System.out.println("Media Player is now PAUSED.");
        context.setState(this);
    }
    public String toString() { return "Pause State"; }
}

// 3. The Context (The object whose behavior changes)
class Context {
    private State state;
    
    public Context() { state = null; }
    
    public void setState(State state) { this.state = state; }
    public State getState() { return state; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 174: State Pattern ===\n");

        System.out.println("Allows an object to alter its behavior when its internal state changes.");
        System.out.println("The object will appear to change its class.\n");

        Context player = new Context();

        // Transition to PLAY
        State playState = new PlayState();
        playState.doAction(player);
        System.out.println("Current Player State: " + player.getState().toString());

        // Transition to PAUSE
        System.out.println("\nUser pressed pause button...");
        State pauseState = new PauseState();
        pauseState.doAction(player);
        System.out.println("Current Player State: " + player.getState().toString());
    }
}
