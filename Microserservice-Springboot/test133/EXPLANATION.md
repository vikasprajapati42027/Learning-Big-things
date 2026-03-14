# Test 133: AES Encryption

Encrypting sensitive fields (like PAN, SSN) before saving to the database.

## Key Files:
- `AesEncryptionService.java`: Full encrypt and decrypt using the Java `javax.crypto` package.
- `EXPLANATION.md`: Field-level vs full-disk encryption.

## Concept:
Even if a hacker steals your database dump, they cannot read `user_ssn` because the values are encrypted with a secret key that lives outside the database (in Vault). AES-256 is military-grade encryption used by banks.
