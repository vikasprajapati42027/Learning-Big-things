# Test 70: Neo4j (Graph Database)

Relationships are first-class citizens.

## Why use a Graph DB?
In SQL, finding "Friends of Friends" requires many slow **JOINs**. 
In Neo4j, you just go from one node to another through a **Relationship**. It's incredibly fast for highly connected data.

## Cypher:
The query language for Neo4j. It looks visual:
`MATCH (p:Person {name: "Vikas"})-[:FRIEND_OF]->(f) RETURN f`
(Find Vikas, follow friend relationship, return the friends).
