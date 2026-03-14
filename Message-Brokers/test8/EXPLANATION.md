# Test 8: AWS SQS & SNS

## SQS — Simple Queue Service
Pull-based queue. Consumer polls SQS for new messages.

```
Producer → SQS Queue → Consumer pulls → Process → Delete message
```

### Spring Integration
```java
@SqsListener("${aws.sqs.queue.name}")
public void onMessage(String message) {
    System.out.println("Got from SQS: " + message);
}
```

### properties
```properties
cloud.aws.region.static=ap-south-1
cloud.aws.sqs.queue.name=my-orders-queue
```

## SNS — Simple Notification Service
Push-based fan-out. SNS distributes to multiple subscribers.

```
SNS Topic → Email Subscriber
          → SQS Queue 1 (Order Service)
          → SQS Queue 2 (Notification Service)
          → Lambda Function
```

## SQS vs SNS
| Feature | SQS | SNS |
|---------|-----|-----|
| Model | Pull (poll) | Push |
| Delivery | One consumer | Many subscribers |
| Use case | Work queue | Fan-out / notifications |
