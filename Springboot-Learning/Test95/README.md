# Test 95: OAuth2 Social Login

"Login with Google" made easy.

## How it works:
1. User clicks "Login with Google".
2. App redirects user to Google's server.
3. User signs in and approves the app.
4. Google sends an **Authorization Code** back to the app.
5. App exchanges code for an **Access Token**.
6. App fetches user data (Email, Name) and logs them in.

## Benefit:
- User doesn't need to create a new password.
- You don't need to worry about storing/hashing passwords securely.
