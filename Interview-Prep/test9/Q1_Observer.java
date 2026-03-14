/**
 * INTERVIEWER: Explain the Observer Pattern.
 * CANDIDATE: Defines a one-to-many dependency so that when one object changes state, all its dependents are notified.
 */
import java.util.*;
interface Subscriber { void update(String msg); }
class YouTubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();
    public void addSubscriber(Subscriber s) { subscribers.add(s); }
    public void uploadVideo(String title) {
        System.out.println("Uploading: " + title);
        subscribers.forEach(s -> s.update("New Video: " + title));
    }
}
public class Q1_Observer {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();
        channel.addSubscriber(m -> System.out.println("User A received: " + m));
        channel.addSubscriber(m -> System.out.println("User B received: " + m));
        channel.uploadVideo("Java Design Patterns Masterclass");
    }
}
