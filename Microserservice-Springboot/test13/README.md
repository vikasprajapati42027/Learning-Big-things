# Test 13: Microservice Versioning

How to update an API without breaking mobile apps for millions of users.

## Strategies:
1. **URI Versioning (Most Common)**: 
   `/v1/employees` and `/v2/employees`.
2. **Header Versioning**: 
   `Accept: application/vnd.company.v2+json`.

## Best Practice:
Never delete `v1` on the day you release `v2`. Keep both running. Monitor how many users are still on `v1`. Only when it reaches 0% can you safely shut it down.

Spring Boot supports this easily via mapping:
`@GetMapping(value = "/employees", params = "version=1")`
