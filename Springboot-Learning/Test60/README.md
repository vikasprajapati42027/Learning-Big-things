# Test 60: Observability (Micrometer)

If you can't measure it, you can't manage it.

## The 3 Pillars:
1. **Metrics**: "How many requests per second?".
2. **Logging**: "What happened at 10 AM?".
3. **Tracing**: "Why was THIS specific request slow?".

## Micrometer:
It's like SLF4J but for metrics. You write your metric code once, and you can send it to **Prometheus**, **InfluxDB**, or **New Relic** just by changing a dependency!
