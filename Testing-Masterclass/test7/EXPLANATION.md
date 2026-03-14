# Test 7: WireMock — Mocking External HTTP APIs

## Problem
Your service calls Stripe, OpenAI, or any external API.
In tests, you don't want to make REAL calls (cost, speed, reliability).

## Solution: WireMock
WireMock starts a fake HTTP server on localhost that responds exactly as you configure.

## Example
```java
@SpringBootTest
@AutoConfigureWireMock(port = 8089) // Starts fake server on port 8089
class PaymentServiceTest {

    @Test
    void testStripePayment() {
        // Arrange: Configure fake Stripe response
        stubFor(post(urlEqualTo("/v1/charges"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{\"id\":\"ch_123\",\"status\":\"succeeded\"}")));

        // Act: Call your service (it calls fake Stripe, not real one)
        PaymentResult result = paymentService.charge("tok_visa", 1000);

        // Assert
        assertEquals("succeeded", result.getStatus());
        verify(postRequestedFor(urlEqualTo("/v1/charges")));
    }
}
```
```properties
stripe.base-url=http://localhost:8089  # Override in test properties!
```
