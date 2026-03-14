# Test 36: Pagination and Sorting

Don't crash your server with too much data.

## Why Paginate?
1. **Performance**: Smaller SQL result sets.
2. **User Experience**: Browsing data in pages is natural.
3. **Memory**: Prevents `OutOfMemoryError` in your Java app.

## Page vs List:
- `List<T>`: Just the data.
- `Page<T>`: The data + metadata (total pages, current page number, has next page?).

## Sorting:
Use `Sort.by("field").ascending()` or combine them:
`Sort.by("category").ascending().and(Sort.by("price").descending())`
