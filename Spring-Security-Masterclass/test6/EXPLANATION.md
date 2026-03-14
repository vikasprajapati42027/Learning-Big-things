# Test 6: CSRF & CORS Security

## CSRF (Cross-Site Request Forgery)
An attacker tricks a logged-in user's browser into making unwanted requests.
Example: You visit evil.com, it secretly sends `POST /transfer-money` to your bank!

### When to disable CSRF:
- REST APIs using JWT (stateless) → **Disable** — tokens prevent CSRF naturally
- Traditional web apps with sessions → **Keep enabled**

## CORS (Cross-Origin Resource Sharing)
Browser blocks requests from `localhost:3000` (React) to `localhost:8080` (Spring) by default.
Spring CORS config tells the browser: "I trust this origin."

### Key CORS fields:
| Field | Purpose |
|-------|---------|
| `allowedOrigins` | Which domains can call your API |
| `allowedMethods` | GET, POST, etc. |
| `allowedHeaders` | Which headers can be sent |
| `allowCredentials` | Allow cookies/auth headers |

## Golden Rule
CSRF and CORS are DIFFERENT problems.
- CORS = Browser protection (who can MAKE requests)
- CSRF = Server protection (forgery prevention for session-based auth)
