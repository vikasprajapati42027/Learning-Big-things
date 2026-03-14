# Test 47: Active Record vs Data Mapper

## ⚔️ 1. The Rivalry
- **Active Record**: The object "Knows" how to save itself. `user.save()`. (Simple, used in PHP/Ruby).
- **Data Mapper**: The object is dumb. A separate "Mapper" handles saving. `mapper.save(user)`. (Cleaner but more complex, used in Hibernate/Spring).
