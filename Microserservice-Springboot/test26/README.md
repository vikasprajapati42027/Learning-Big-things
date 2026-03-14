# Test 26: HashiCorp Vault Integration

Securely managing passwords and secrets.

## The Problem:
If you put your database password in `application.properties`, anyone with access to your Git or server can see it. That's a huge security risk.

## The Solution (Vault):
HashiCorp Vault is like a "Digital Safe".
- You store your passwords in Vault.
- When your microservice starts, it asks Vault: "Give me the DB password for the 'employee-service'."
- Vault verifies the service and gives the password only for a limited time.

## Key Config:
```properties
spring.cloud.vault.uri=http://localhost:8200
spring.cloud.vault.token=my-root-token
spring.config.import=vault://
```
Now, `@Value("${my.secret}")` will fetch the value directly from the secure Vault!
