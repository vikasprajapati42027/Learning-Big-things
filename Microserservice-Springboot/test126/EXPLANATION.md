# Test 126: Blue-Green Deployment

Zero-downtime releases by switching between two identical environments.

## Key Files:
- `DeployController.java`: Demonstrates the concept of identifying the active version.
- `EXPLANATION.md`: Logic of the Load Balancer switch.

## Concept:
You have two identical production setups: **Blue** (Running the old code) and **Green** (Running the new code). Once Green is tested and ready, the Load Balancer points all traffic to Green. If anything goes wrong, you switch back to Blue in 1 second. Zero users ever see a "Maintenance" page!
