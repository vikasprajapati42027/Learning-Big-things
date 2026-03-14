# Test 39: Multi-tenancy

Scale your SaaS application.

## Core Idea:
Multi-tenancy is an architecture where a single instance of a software application serves multiple customers. Each customer is called a **tenant**.

## Key Challenge: Data Isolation
You must ensure Tenant A can NEVER see Tenant B's data.

## Implementation in Spring:
You typically use a `CurrentTenantContext` (based on `ThreadLocal`) to store the tenant ID from the request header, and a `RoutingDataSource` to switch databases dynamically.
