package TestJava.Test138;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

// A Processor is both a Subscriber AND a Publisher simultaneously!
// It sits in the middle of a pipeline, receives data, transforms it, and publishes the result.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Flow API: Processor (Data Transformation) ===\n");

        try (SubmissionPublisher<String> rawPublisher = new SubmissionPublisher<>()) {

            // 1. Create a Processor (Takes Strings, outputs Integers)
            // It parses Strings into numbers, and filters out invalid ones.
            TransformProcessor processor = new TransformProcessor();

            // 2. Create the Final End-Subscriber
            Flow.Subscriber<Integer> finalSubscriber = new Flow.Subscriber<>() {
                private Flow.Subscription subscription;
                
                @Override
                public void onSubscribe(Flow.Subscription sub) {
                    this.subscription = sub;
                    this.subscription.request(Long.MAX_VALUE); // Give me everything!
                }
                
                @Override
                public void onNext(Integer item) {
                    System.out.println("[Final Sink] Safely computed: " + (item * 10));
                }
                
                @Override public void onError(Throwable t) {}
                @Override public void onComplete() {}
            };

            // 3. Chain them together!
            // Publisher -> Processor -> Subscriber
            rawPublisher.subscribe(processor);
            processor.subscribe(finalSubscriber);

            System.out.println("Feeding raw strings into the pipeline...\n");
            
            rawPublisher.submit("50");
            rawPublisher.submit("Hello!"); // Should be filtered out
            rawPublisher.submit("90");
            
            Thread.sleep(1000);
            
            // Closing processors
            processor.close();
        }
    }
}

// Custom Processor implementation extending SubmissionPublisher bounds it to an internal async pool automatically.
class TransformProcessor extends SubmissionPublisher<Integer> implements Flow.Processor<String, Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        try {
            int transformed = Integer.parseInt(item);
            System.out.println("[Processor] Successfully parsed: " + item);
            
            // Re-publish the transformed item!
            this.submit(transformed);
        } catch (NumberFormatException e) {
            System.out.println("[Processor] Dropping invalid data: " + item);
        }
        
        // Always request the next item
        this.subscription.request(1);
    }

    @Override public void onError(Throwable t) { this.closeExceptionally(t); }
    @Override public void onComplete() { this.close(); }
}
