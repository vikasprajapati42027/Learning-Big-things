# Test 30: Event Sourcing (The "State" Log)

Recording history, not just the result.

## The Problem:
In a normal DB, if a user changes their name from "Vikas" to "Vikky", you overwrite the data. "Vikas" is gone forever.

## The Solution (Event Sourcing):
You never "UPDATE" data. You only "INSERT" events.
- Event 1: User Created (Name: Vikas)
- Event 2: Name Changed (To: Vikky)

To know the current name, you "Replay" all events. 
### Why use it?
- **Audit**: You have a perfect history of everything that happened.
- **Time Travel**: You can see what the database looked like 3 months ago!
