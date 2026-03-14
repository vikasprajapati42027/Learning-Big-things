class FluxParent { void subscribe() { System.out.println("Subscribed to data stream"); } }
class EventFlux extends FluxParent { }
public class ReactiveDataDemo {
    public static void main(String[] args) { new EventFlux().subscribe(); }
}
