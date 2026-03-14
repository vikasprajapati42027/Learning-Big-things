# Test 47: API Documentation (Swagger/OpenAPI Aggregation)

One documentation for 50 services.

## The Problem:
Every service has its own Swagger page. 
`localhost:8081/swagger-ui.html`
`localhost:8082/swagger-ui.html`

## The Solution:
You configure the **API Gateway** to aggregate all documentation.
The developer opens `localhost:9191/swagger-ui.html` and can select "Employee Service" or "Department Service" from a dropdown.

One portal, every API!
