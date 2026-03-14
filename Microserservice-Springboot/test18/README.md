# Test 18: SAGA Pattern (Choreography)

Managing transactions that span multiple microservices.

## The Rule of One:
In microservices, one service = one database. You cannot do a single SQL transaction across two services.

## SAGA Choreography:
It's like a dance. Each service does its job and shouts "I'm done!".
1. **Order Service**: Creates order -> Fires `OrderCreated` event.
2. **Payment Service**: Hears event -> Charges card -> Fires `PaymentSuccess` event.
3. **Inventory Service**: Hears event -> Subtracts stock.

If Payment fails? It fires `PaymentFailed`, and the Order service hears it and Cancels the order (Compensating Transaction).
No "Central Manager" needed!
