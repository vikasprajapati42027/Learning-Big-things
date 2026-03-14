# Test 2: Mockito — Mocking Dependencies

## Simple Explanation
Mockito creates fake versions of your dependencies so you can test your service
in isolation — without a real database, real API, or real filesystem.

## Core Annotations
```java
@Mock UserRepository repo;          // Creates a fake Repository
@InjectMocks UserService service;   // Injects fakes into the real service
@Captor ArgumentCaptor<User> captor; // Captures what was passed to the mock
```

## Key Operations
```java
// Stubbing — define behavior
when(repo.findById(1L)).thenReturn(Optional.of(new User("Vikas")));
when(repo.save(any())).thenThrow(new RuntimeException("DB error"));

// Verification — check what happened
verify(repo, times(1)).save(any(User.class));       // Called once
verify(repo, never()).delete(any());                 // Never called
verify(repo).save(captor.capture());                 // Capture the argument
assertEquals("Vikas", captor.getValue().getName());  // Assert what was saved
```

## Spy vs Mock
- `@Mock` → Complete fake, all methods return null/0/empty by default
- `@Spy` → Real object, but specific methods can be stubbed
```java
@Spy List<String> realList = new ArrayList<>(); // Real list, can stub specific methods
```
