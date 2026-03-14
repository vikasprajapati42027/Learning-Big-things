# Test 45: API Gateway (Spring Cloud Gateway)

The "Front Door" of your Microservices.

## Routing:
Instead of clients calling 20 different services, they call ONE gateway.
The gateway routes `/orders/**` to Order Service and `/products/**` to Product Service.

## Filters:
You can use **Pre-filters** to check if a user has a valid token before the request even reaches the service. This saves CPU and bandwidth!
