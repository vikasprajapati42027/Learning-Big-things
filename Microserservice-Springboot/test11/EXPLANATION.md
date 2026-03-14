# Test 11: API Gateway Service

## 🚪 1. What is an API Gateway?
In a microservices architecture, consumers/clients shouldn't have to know the address of 100 different services. The **API Gateway** acts as a single entry point.

## 🖱️ 2. Core Features
1. **Routing**: Forwards requests to the correct service (e.g., `/users` -> User Service).
2. **Security**: Handles authentication before the request hits internal services.
3. **Rate Limiting**: Prevents any single client from overloading the system.

## 🚀 3. Hierarchy in this Example
- **Parent**: `GatewayApplication` (The Entry Point).
- **Child**: `UserApplication` (The Downstream Service).
The Gateway "wraps" the backend services to provide a clean interface to the user.
