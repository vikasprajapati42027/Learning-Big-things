public class FacadeDemo {
    public static void main(String[] args) {
        // Complex components
        SoundSystem sound = new SoundSystem();
        Projector projector = new Projector();
        Lights lights = new Lights();

        // The Facade!
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(sound, projector, lights);

        // One button press instead of manual setup
        homeTheater.watchMovie();
        homeTheater.endMovie();
    }
}
