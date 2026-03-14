# Test 49: GraphQL Federation

The "Graph" of Microservices.

## Concept:
Instead of REST, you use GraphQL.
But if you have 10 microservices, you don't want 10 GraphQL endpoints.

## Federation:
- Every microservice provides a "piece" of the graph.
- The **Gateway** (Router) puts the pieces together.
- The user asks for: `"Get User { name, orders { id, price } }"`
- The Gateway automatically asks the **User Service** for the name and the **Order Service** for the prices, then merges them.

The user thinks it's one giant database!
