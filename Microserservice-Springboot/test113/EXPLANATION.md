# Test 113: CORS Configuration

Allowing your frontend app to call your backend API safely.

## Key Files:
- `CorsConfig.java`: Centralized CORS rules for different origins and methods.
- `EXPLANATION.md`: Why browsers block cross-origin requests by default.

## Concept:
Browsers block requests from `localhost:3000` (React) to `localhost:8080` (Spring) for security reasons. CORS configuration explicitly tells the browser: "It's okay, I trust this origin." Without it, your entire frontend is broken!
