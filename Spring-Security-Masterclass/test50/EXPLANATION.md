# Test 50: Security Master Checklist

## 🛡️ Production Readiness Checklist

### 1. Authentication
- [ ] No hardcoded passwords or secrets in properties files.
- [ ] Passwords hashed with BCrypt (10+ rounds) or Argon2.
- [ ] MFA (Multi-Factor) implemented for sensitive accounts.

### 2. Authorization
- [ ] Principal of Least Privilege: Users only have roles they NEED.
- [ ] `@PreAuthorize` used on all critical service methods.
- [ ] Global Exception Handler hides internal stack traces from users.

### 3. Protection
- [ ] CSRF enabled for session-based apps.
- [ ] CORS limited to specific trusted domains.
- [ ] HSTS, NoSniff, and Frame-Deny headers enabled.
- [ ] Input validation (JSR-303) on all `@RequestBody` objects.

### 4. Infrastructure
- [ ] Rate Limiting active at the API Gateway.
- [ ] Database is in a private subnet (not public).
- [ ] Secrets managed via secret manager (K8s/AWS), not Env Vars.

### 5. Monitoring
- [ ] Audit logs for login failures and permission changes.
- [ ] Real-time alerts for 5xx errors or sudden traffic spikes.

**Stay Secure, Vikas! 🛡️**
