public class Computer {
    private Keyboard keyboard;
    
    // We don't say "new StandardKeyboard()".
    // We expect SOME keyboard to be given to us from outside!
    public Computer(Keyboard k) {
        this.keyboard = k;
    }
}
