# Test 45: Chaos Engineering (Chaos Monkey)

Breaking things on purpose to become stronger.

## Concept:
What happens to your website if you suddenly "kill" 2 random microservices in production?
- Does the whole site crash? (Bad)
- Does only 1 feature disappear with a nice error? (Good)

## Chaos Monkey for Spring Boot:
It's a library that randomly "attacks" your app by:
- Adding 10 seconds of delay.
- Throwing unexpected Exceptions.
- Killing the server.

If your system can survive the Chaos Monkey, it's ready for any real-world disaster!
