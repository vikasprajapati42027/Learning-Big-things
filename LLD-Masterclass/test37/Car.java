public class Car {
    // COMPOSITION: Car HAS AN Engine.
    // (Instead of Car EXTENDS Engine)
    private Engine engine = new Engine();

    public void move() {
        engine.start();
        System.out.println("Car is moving!");
    }
}
