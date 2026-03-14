# Test 10: Git-Based Configuration

Moving settings to a Version Control system.

## Why Git?
1. **History**: You can see every change made to your settings over the last year.
2. **Rollback**: If a change breaks production, you can revert the Git commit in seconds.
3. **Branches**: You can have a `dev` branch for development settings and a `master` branch for production.

## Configuration:
```properties
spring.cloud.config.server.git.uri=https://github.com/user/your-config-repo
spring.cloud.config.server.git.clone-on-start=true
```

In this mode, the Config Server clones the repo locally so it can still serve settings if GitHub goes down temporarily.
