# Test 128: Feature Toggling (Togglz)

Enabling or disabling code features without a deployment.

## Key Files:
- `DiscountService.java`: Demonstrates using a `FeatureManager` to control logic flow.
- `EXPLANATION.md`: Dark Launches and A/B Testing.

## Why use it?
It allows you to merge code to production even if it's not finished. You keep the feature "Off" for users but "On" for developers. Once ready, you flip the switch in a dashboard, and everyone sees it instantly.
