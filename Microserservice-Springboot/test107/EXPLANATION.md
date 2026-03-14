# Test 107: Multi-tenancy (SaaS Architecture)

Running one application for multiple different companies (Tenants).

## Key Files:
- `CustomerController.java`: Demonstrates using a "Tenant ID" header to isolate data.
- `EXPLANATION.md`: Shared Database vs Separate Schema strategies.

## Concept:
In a SaaS app like Slack or Shopify, every customer feels like they have their own app, but they all share the same code. This module shows how to ensure "Company A" can never see "Company B's" data in a shared environment.
