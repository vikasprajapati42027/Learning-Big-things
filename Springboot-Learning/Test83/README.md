# Test 83: AWS Lambda with Spring Boot

Running Spring in the Cloud safely.

## The Challenge:
Spring Boot is heavy. AWS Lambda charges for execution time and memory.

## Best Practices:
1. **Spring Cloud Function**: Use the adapter for AWS.
2. **Lambda Handler**: Use `SpringBootStreamHandler`.
3. **Provisioned Concurrency**: Keeps instances "warm" to avoid cold starts.
4. **Spring Native**: (Recap from Test 59) Mandatory for real-world production Lambdas to get 0.1s startup.
