# Test 97: OAuth2 Authorization Server

Become the Identity Provider.

## Role:
It manages users, client applications (like a Mobile App id), and issues tokens (JWTs) after successful authentication.

## Use Case:
If you are building a platform like GitHub or Twitter, where THIRD-PARTY apps want to access your users' data, you need your own Authorization Server.

Instead of rolling your own, Spring provide a production-ready implementation that follows the latest OAuth2 and OpenID Connect standards.
