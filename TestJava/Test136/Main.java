package TestJava.Test136;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

// The Flow API (Java 9+) implements the Reactive Streams standard locally.
// It consists of Publishers, Subscribers, Subscriptions, and Processors.
// This is the foundation for tools like RxJava, Project Reactor (Spring WebFlux), and Akka Streams.

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Flow API: Publisher & Subscriber ===\n");

        // 1. Create a Publisher
        // SubmissionPublisher is the standard implementation provided by Java.
        // It manages async delivery to subscribers using a ThreadPool (ForkJoinPool by default).
        try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>()) {

            // 2. Create a Subscriber
            Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
                private Flow.Subscription subscription;
                
                @Override
                public void onSubscribe(Flow.Subscription subscription) {
                    System.out.println("[Subscriber] Subscribed to Publisher!");
                    this.subscription = subscription;
                    
                    // Request the first item! (This prevents the publisher from overwhelming the subscriber - "Backpressure")
                    this.subscription.request(1); 
                }

                @Override
                public void onNext(String item) {
                    System.out.println("[Subscriber] Received item: " + item);
                    // Process the item, then request the NEXT item
                    this.subscription.request(1);
                }

                @Override
                public void onError(Throwable throwable) {
                    System.err.println("[Subscriber] Error: " + throwable.getMessage());
                }

                @Override
                public void onComplete() {
                    System.out.println("[Subscriber] Stream Processing Complete!");
                }
            };

            // 3. Connect them!
            publisher.subscribe(subscriber);

            // 4. Publish Data asynchronously
            System.out.println("Publishing events...");
            publisher.submit("Event 1: User Logged In");
            publisher.submit("Event 2: Item Added to Cart");
            publisher.submit("Event 3: Checkout Started");

            // Give the async pool time to process the events before exiting
            Thread.sleep(1000); 
            
            // Closing the try-with-resources effectively calls publisher.close(), 
            // which triggers the subscriber's onComplete() method!
        }
    }
}
