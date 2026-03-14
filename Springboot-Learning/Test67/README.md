# Test 67: Elasticsearch

Full-text search for your application.

## SQL vs Elasticsearch:
- **SQL**: `WHERE name LIKE '%apple%'` is very slow on millions of records.
- **Elasticsearch**: Uses an **Inverted Index** (like the index at the back of a book). Searching for "apple" is instant regardless of data size.

## Features:
- **Fuzzy Search**: "Appel" will match "Apple".
- **Autocomplete**: Suggesting words as the user types.
- **Scalability**: Horizontal scaling across dozens of servers.
