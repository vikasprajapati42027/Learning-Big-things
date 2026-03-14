# Test 149: API Mocking (WireMock)

Testing your services without calling the real internet.

## Key Files:
- `ExternalApiMock.java`: A service that would usually call a remote URL.
- `EXPLANATION.md`: Why integration tests need stable mocks.

## Why use it?
If you are testing your code against the real Stripe or Gmail API, your tests will fail if the internet is down. WireMock runs a local server that "pretends" to be Stripe. You can tell it: "Return a 404 error for the next 5 calls," allowing you to test how your app handles failures perfectly.
