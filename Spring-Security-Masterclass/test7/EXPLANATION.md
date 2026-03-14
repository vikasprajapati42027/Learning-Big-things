# Test 7: OAuth2 Social Login

## Simple Explanation
Instead of managing passwords yourself, delegate to Google/GitHub:
"If Google says this user is Vikas, I trust Google."

## Dependencies (pom.xml)
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
```

## application.properties
```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_SECRET
spring.security.oauth2.client.registration.google.scope=email,profile
```

## application.yml Security config
```java
http.oauth2Login(oauth2 -> oauth2
    .loginPage("/login")
    .defaultSuccessUrl("/dashboard")
);
```

## OAuth2 Flow (Simplified)
```
User clicks "Login with Google"
    ↓
Browser → Google: "Please authenticate this user"
    ↓
Google: "OK, here is an Authorization Code"
    ↓
Spring: Exchanges code for Access Token
    ↓
Spring: Fetches user profile (email, name) from Google
    ↓
User is logged in! (No password stored in YOUR database)
```
