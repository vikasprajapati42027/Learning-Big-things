# Test 31: CORS vs CSRF

## 1. CORS (Cross-Origin Resource Sharing)
A browser security feature. It prevents a website at `evil.com` from making an AJAX request to your API at `mybank.com`.
- **The Fix**: Your API must send the `Access-Control-Allow-Origin: https://myapp.com` header. 
- **Goal**: Protect the **SERVER'S** data from being read by unauthorized websites.

## 2. CSRF (Cross-Site Request Forgery)
An attack that tricks a user into performing an action (like "Send Money") on a site where they are already logged in.
- **Example**: You are logged into Bank.com. You visit Evil.com. Evil.com has a hidden form that submits to `Bank.com/transfer?amount=1000`. Your browser sends your Bank.com cookies automatically!
- **The Fix**: Use a **CSRF Token** (a secret random string). Every request must include this token. Since Evil.com doesn't know the token, they can't submit the form.
- **Goal**: Protect the **USER** from being tricked.

## When to disable CSRF in Spring?
If your API is **Stateless** (uses JWT, no cookies), you should disable CSRF because JWTs aren't sent automatically by the browser like cookies are.
