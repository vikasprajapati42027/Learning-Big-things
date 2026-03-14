# ============================================================================
# DATABASE MASTERCLASS: TEST 26 - THE 50 MONGODB & NOSQL CHALLENGES
# ============================================================================

# --- 1. CRUD OPERATIONS (BSON) ---
# 1. db.users.insertOne({name: "Vikas", age: 25})
# 2. db.users.insertMany([{name: "A"}, {name: "B"}])
# 3. db.users.find() (Select *)
# 4. db.users.find({age: 25}) (Where age=25)
# 5. db.users.find({age: {$gt: 20}}) (Greater than)
# 6. db.users.find({city: {$in: ["Mumbai", "Delhi"]}}) (In clause)
# 7. db.users.findOne({name: "Vikas"})
# 8. db.users.updateOne({name: "Vikas"}, {$set: {age: 26}})
# 9. db.users.updateMany({}, {$inc: {points: 10}}) (Increment all)
# 10. db.users.deleteOne({name: "A"})

# --- 2. ADVANCED QUERYING ---
# 11. db.users.find().sort({age: -1}) (Order by Desc)
# 12. db.users.find().limit(5).skip(10) (Pagination)
# 13. db.users.find({$or: [{name: "Vikas"}, {age: 30}]})
# 14. db.users.find({tags: "java"}) (Search in array)
# 15. db.users.find({tags: {$all: ["java", "spring"]}}) (Array contains both)
# 16. db.users.find({addr: {$exists: true}})
# 17. db.users.find({name: /^V/}) (Regex - Starts with V)
# 18. db.users.countDocuments({age: {$lt: 18}})
# 19. db.users.distinct("city")
# 20. db.users.find({scores: {$elemMatch: {$gt: 80, $lt: 90}}})

# --- 3. AGGREGATION FRAMEWORK (The "JOIN" replacement) ---
# 21. $match stage: Filter rows
# 22. $group stage: Group by city, count users
# 23. $sort stage: Sort results
# 24. $project stage: Select specific fields
# 25. $lookup stage: Left Outer Join with another collection
# 26. $unwind stage: Flatten an array into multiple rows
# 27. $addFields stage: Calculate new fields
# 28. $out stage: Save results to a new collection
# 29. $facet stage: Multiple pipelines in one query
# 30. $bucket stage: Categorize into ranges (age 10-20, 21-30...)

# --- 4. INDEXING & PERFORMANCE ---
# 31. db.users.createIndex({email: 1}, {unique: true})
# 32. db.users.createIndex({city: 1, age: -1}) (Compound Index)
# 33. db.users.createIndex({comment: "text"}) (Full Text Search)
# 34. db.users.explain().find({age: 25}) (Query plan)
# 35. TTL Index: db.sessions.createIndex({createdAt: 1}, {expireAfterSeconds: 3600})
# 36. Partial Index: Only index users with points > 100
# 37. Sparse Index: Only index rows where field exists
# 38. Geospatial Index: db.places.createIndex({loc: "2dsphere"})
# 39. Hinting an index: .hint("idx_name")
# 40. Dropping an index

# --- 5. DATA MODELING & ARCHITECTURE ---
# 41. Embedding vs Referencing (The big NoSQL question)
# 42. Capped Collections (Fixed size, FIFO)
# 43. Transactions in MongoDB (Session based)
# 44. GridFS (Storing files > 16MB)
# 45. Change Streams (Real-time triggers)
# 46. Replication (Replica Sets - High Availability)
# 47. Sharding (Horizontal scaling - Shard Key choice)
# 48. Write Concern (Acknowledged, Journaled, Majority)
# 49. Read Preference (Primary, SecondaryPreferred)
# 50. Schema Validation (JSON Schema rules)

