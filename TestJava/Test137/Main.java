package TestJava.Test137;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.atomic.AtomicInteger;

// This example demonstrates 'Backpressure' - the core concept of Reactive Streams!
// The Subscriber CONTROLS the rate at which it receives data, so it never crashes from too much load.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Flow API: Backpressure (Subscriber Rate Control) ===\n");

        try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {

            Flow.Subscriber<Integer> slowSubscriber = new Flow.Subscriber<>() {
                private Flow.Subscription subscription;
                private final AtomicInteger processedCount = new AtomicInteger();
                
                @Override
                public void onSubscribe(Flow.Subscription subscription) {
                    this.subscription = subscription;
                    System.out.println("[Slow Subscriber] Subscribed. Give me JUST 2 items first.");
                    
                    // The subscriber explicitly demands exactly 2 items to start
                    this.subscription.request(2);
                }

                @Override
                public void onNext(Integer item) {
                    // Simulate a slow database save or heavy computation
                    try { Thread.sleep(500); } catch (InterruptedException e) {}
                    
                    System.out.println("[Slow Subscriber] Processed item: " + item);
                    
                    // We only request more data AFTER processing the current batch successfully!
                    if (processedCount.incrementAndGet() % 2 == 0) {
                        System.out.println("[Slow Subscriber] Ready for 2 more...");
                        this.subscription.request(2);
                    }
                }

                @Override
                public void onError(Throwable throwable) {}

                @Override
                public void onComplete() {
                    System.out.println("[Slow Subscriber] Done.");
                }
            };

            publisher.subscribe(slowSubscriber);

            System.out.println("[Publisher] Blasting 10 items instantly to the buffer!");
            for (int i = 1; i <= 10; i++) {
                publisher.submit(i);
            }
            
            System.out.println("[Publisher] Finished immediately. Waiting for slow subscriber to catch up...\n");

            // Wait a few seconds to watch the slow subscriber pull data at its own pace
            Thread.sleep(3000); 
        }
    }
}
