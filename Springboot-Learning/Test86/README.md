# Test 86: CQRS Pattern

Separation of concerns at the database level.

## Core Idea:
- **Command**: Changes state (Insert/Update/Delete). Optimized for writing.
- **Query**: Reads state (Select). Optimized for search/reporting.

## Why?
You can use a relational database for Commands (for ACID) and a search engine like Elasticsearch for Queries (for Speed).
It allows you to scale reads and writes independently!
