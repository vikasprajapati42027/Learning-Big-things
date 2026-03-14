# Test 123: HATEOAS (Hypermedia as the Engine of Application State)

Making your REST API self-discoverable by including links in responses.

## Key Files:
- `HateoasController.java`: Returns an `EntityModel` with self-link and action links.
- `EXPLANATION.md`: Level 3 REST — the highest level of REST maturity.

## Concept:
A HATEOAS response looks like: `{ "id": 1, "item": "Laptop", "_links": { "self": "/orders/1", "cancel": "/orders/1/cancel" } }`. The client doesn't need to know the URLs in advance — the API tells it what actions are possible!
