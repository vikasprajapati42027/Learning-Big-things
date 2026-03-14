# Test 49: GraphQL

Say goodbye to Over-fetching and Under-fetching data.

## REST vs GraphQL:
- **REST**: You call `/users/1` and get everything. If you only wanted the `name`, you wasted bandwidth.
- **GraphQL**: You ask for `user(id: 1) { name }` and the server returns ONLY the `name`.

## Why?
- **Mobile Apps**: Faster load times on slow networks.
- **One Endpoint**: No more `/users`, `/orders`, `/products`. Everything is `/graphql`.
