# Test 45: Specification Pattern

## 📋 1. Simple Explanation
If you have a complex search like: "Find all Blue cars, manufactured after 2020, with 4 doors."
Instead of passing 10 parameters to a method, you create a `BlueCarSpecification` object. 
- You can combine them: `NewCarSpec.and(BlueCarSpec)`.
It turns "Business Rules" into reusable objects.
