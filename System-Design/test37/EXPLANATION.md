# Test 37: Bloom Filters

## Simple Explanation
A Bloom Filter is a probabilistic data structure that tells you if an item is in a set.

## The Catch
- It can give **False Positives**: It might say "Yes, I've seen 'Vikas'" when it hasn't.
- It **NEVER** gives **False Negatives**: If it says "No", then 'Vikas' is 100% NOT there.
- You **cannot delete** items from a standard Bloom Filter.

## Why use it? (Speed vs Memory)
It uses ALMOST NO MEMORY compared to a HashMap.
1. **Database Search**: Before doing a slow DB query, check the Bloom Filter. If it says "No", skip the query!
2. **Username Availability**: Instantly check if a username is taken.
3. **Spam Filters**: Quickly check if an email or URL is in a blacklist of 1 billion items using just a few MBs of RAM.

## How it works
It uses multiple **Hash Functions** to turn your string into a few "bits" (0 or 1) in a large BitSet. If all those bits are 1, the item *might* be there.
