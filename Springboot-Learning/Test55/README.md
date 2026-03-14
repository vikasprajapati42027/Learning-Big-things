# Test 55: Mono and Flux (Project Reactor)

The language of Reactive Programming.

## Mono:
Used when you expect exactly one result (like `findById`). It's like a `Future` but better.

## Flux:
Used when you expect a list or a stream of data (like `findAll`).

## Key Rule:
**Nothing happens until you subscribe!** 
Just defining a Flux doesn't start the execution. You must `.subscribe()` or return it to WebFlux for it to run.
