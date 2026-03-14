# Test 27: Content Negotiation

Support more than just JSON!

## How to use:
1. Add the XML dependency: `jackson-dataformat-xml`.
2. Spring will check the `Accept` header from the client.
3. If the client asks for `application/xml`, Spring converts the object to XML using Jackson.

## Explicit mapping:
You can force a format using the `produces` attribute in `@GetMapping`.
