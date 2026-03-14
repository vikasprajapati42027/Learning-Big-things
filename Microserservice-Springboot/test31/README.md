# Test 31: Strangler Fig Pattern

Safely killing a Monolith.

## Concept:
You have a huge, old Monolith app. You want to move to Microservices. 
**Don't rewrite everything at once!** (This usually fails).

## The Flow:
1. Put an **API Gateway** in front of the Monolith.
2. Build ONE microservice (e.g., "Payments").
3. Tell the Gateway: "For /payments, go to the new Microservice. For everything else, go to the old Monolith."
4. Repeat for "Orders", "Users", etc.
5. Over time, the Monolith shrinks and the Microservices grow, until the Monolith is empty and can be deleted.

Just like a Strangler Fig vine grows around a tree until the tree dies!
