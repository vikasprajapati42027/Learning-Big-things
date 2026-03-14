# Test 28: Canary Deployment

Testing on real users with low risk.

## Concept:
Instead of moving everyone from v1 to v2, you move only **5% of users** to the new version (the "Canaries").

## Why do it?
If there is a hidden bug, only 5% of your users are affected. You monitor their logs. If they have no errors for 1 hour, you move 25%, then 50%, then 100%.

It's named after canaries in coal mines—if the canary is okay, the environment is safe!
