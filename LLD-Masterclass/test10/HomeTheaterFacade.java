// The Simple Remote Control (The Facade)
public class HomeTheaterFacade {
    private SoundSystem sound;
    private Projector projector;
    private Lights lights;

    public HomeTheaterFacade(SoundSystem s, Projector p, Lights l) {
        this.sound = s;
        this.projector = p;
        this.lights = l;
    }

    // One simple method replaces 10 complex steps!
    public void watchMovie() {
        System.out.println("Get ready to watch a movie...");
        lights.dim();
        projector.on();
        projector.setInput("Netflix");
        sound.on();
        sound.setVolume(10);
        System.out.println("Movie is starting! Enjoy.");
    }

    public void endMovie() {
        System.out.println("Shutting down movie theater...");
        lights.on();
        System.out.println("All systems cleared.");
    }
}
