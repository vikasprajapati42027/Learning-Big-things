# Test 1: Scala Control Structure Playground

## Overview
This module introduces Scala control structures through a single object that prints the results of `if/else`, `for`, `while`, `do/while`, and `foreach`. It is intentionally verbose so you can scroll through ~100 lines of working Scala code and see how each control statement behaves.

## Run instructions
Install sbt (if not already installed) and then:

```bash
cd Scala-Learning/test1
sbt run
```

The app prints labeled sections for each control structure.

- ## Learning points
- `if/else` expressions yield values and can be nested.
- `for` comprehensions iterate ranges, collections, and guards.
- `while` and `do/while` cover imperative loops with manual counters.
- `foreach` demonstrates iteration over collections with lambdas.
- `repeatUntil` helper shows a simple tail-recursive loop.
- The companion `basic2_BasicScalaConcepts` object covers values, functions, pattern matching, tuples, options, and collection helpers.
- Added `basic2_ClassesAndTraits` to highlight case classes, traits, companion objects, and simple factories.
- Added `basic2_BasicScalaFlow` to highlight lazy evaluation, higher-order functions, tail recursion, partial functions, and collection transforms.
- Added `basic3_FunctionalPatterns` so you can explore sealed-trait modeling, tail-recursive guards, resource loan patterns, lazy streams, and for-comprehension monads.
- Added `basic3_ConcurrencyAndIO` to showcase simple Futures, sequencing, blocking IO, and thread-local propagation.
- Added `basic3_TypeSystemExploration` to highlight generics, context bounds, structural types, type aliases, and dependent types.
- Added `basic4_ImplicitTypeClassDemo` to demonstrate type classes, implicit syntax, and custom formatting helpers.
- Added `basic4_StringProcessing` to show multiline strings, regex extraction, interpolation, and custom splitting helpers.
- Added `basic4_CollectionsPlayground` to highlight Seq/Map/Set transformations, LazyList, and a custom iterator.
- Added `basic5_ErrorHandlingDemo` to walk through `Try`, recover/fold, and resource guards.
- Added `basic5_AdvancedPatternMatching` to cover sequence, infix, guard, and custom extractor matches.
- Added `basic5_ParserCombinatorDemo` to illustrate Scala parser combinators with expressions and key/value parsing.
- Added `basic6_FileIoPlayground` to demonstrate basic NIO operations (write, read, append, delete).
- Added `basic6_NumericSeries` so you can experiment with prime filtering, arithmetic/geometric sequences, and sliding-window averages.
- Added `basic6_FunctionalStreams` to explore LazyList pipelines, windowed sums, and event priority ordering.
- Added `basic7_FunctionCombinators` to explore `compose/andThen`, memoization, and partial-function chaining.
- Added `basic7_EffectfulFunctionDemo` to illustrate mapping/flatMapping with `Option`, `Either` chains, and `Future` transformations.
- Added `basic7_ParallelCollectionDemo` to show basic parallel collection usage for mapping, aggregating, and capturing thread IDs.
- Added `basic8_ReaderWriterDemo` to highlight simple Reader/Writer combinations for config + logging.
- Added `basic9_PatternsAndData` to cover option zips, map/filter/reduce pipelines, lazy view operations, and case-class copying.
- Added `basic10_DataStreaming` to demonstrate chunked batches, sliding aggregates, and a simple async simulation helper.
- Added `basic11_StateMachine` to show simple state transitions and immutable copy-on-write modeling.
- Added `basic12_MetricsSimulation` to explore counters, histogram bins, and sliding window rates.
- Added `basic13_CommandPattern` to demonstrate the command pattern, replayability, and undo semantics.
- Added `basic14_LoggingDsl` to show a simple DSL that logs with chained metadata updates.
- Added `basic15_GraphTraversal` to show depth-first search over an adjacency map.
- Added `basic16_ConfigValidator` to demonstrate `Either` validation of configuration maps.
- Added `basic17_EventSourcing` to fold domain events into state transitions.
- Added `basic18_AsyncRetry` to simulate a retry loop with decreasing attempts.
- Added `basic19_MetricsAggregator` to aggregate numeric samples per metric name.
- Added `basic20_CommandLine` to parse simple `--key value` command-line pairs.
- Added `basic21_RequestSimulator`, `basic22_RouteParser`, `basic23_LazyTransforms`, `basic24_BinaryMask`, `basic25_Scheduler`, `basic26_EventAggregator`, `basic27_RandomWalk`, `basic28_TimeSeries`, `basic29_StringCombiner`, and `basic30_RandomGenerator` to keep widening the hands-on examples.
- Each `basicN_*` Scala file now includes inline comments describing what every helper does, making the code self-explanatory as you step through the examples.
- Added `FunctionCombinators` to explore `compose/andThen`, memoization, and partial-function chaining.

## Sequenced pathway (basicN)
1. **basic1** – `basic1_ControlStructureExamples` (if/else, loops, repeatUntil).
2. **basic2** – `basic2_BasicScalaConcepts`, `basic2_ClassesAndTraits`, `basic2_BasicScalaFlow` covering values/vars, pattern matching, and higher-order functions.
3. **basic3** – `basic3_FunctionalPatterns`, `basic3_ConcurrencyAndIO`, `basic3_TypeSystemExploration`.
4. **basic4** – `basic4_ImplicitTypeClassDemo`, `basic4_StringProcessing`, `basic4_CollectionsPlayground`.
5. **basic5** – `basic5_ErrorHandlingDemo`, `basic5_AdvancedPatternMatching`, `basic5_ParserCombinatorDemo`.
6. **basic6** – `basic6_FileIoPlayground`, `basic6_NumericSeries`, `basic6_FunctionalStreams`.
7. **basic7** – `basic7_FunctionCombinators`, `basic7_EffectfulFunctionDemo`, `basic7_ParallelCollectionDemo`.
8. **basic8** – `basic8_ReaderWriterDemo` plus references to the other basic sets when you need them again.
9. **basic9** – `basic9_PatternsAndData` for option zips, pipelines, lazy views, and case-class copying.
10. **basic10** – `basic10_DataStreaming` for chunked batch processing, sliding-window aggregates, and a simple async simulation.
11. **basic11** – `basic11_StateMachine` to explore finite-state transitions and immutable data updates.
12. **basic12** – `basic12_MetricsSimulation` covering counters, histogram bins, and sliding-rate windows.
13. **basic13** – `basic13_CommandPattern` for command sequencing plus undo logic.
14. **basic14** – `basic14_LoggingDsl` for lightweight logging DSLs.
15. **basic15** – `basic15_GraphTraversal` for DFS over adjacency maps.
16. **basic16** – `basic16_ConfigValidator` using `Either` for config validation.
17. **basic17** – `basic17_EventSourcing` reconstructing state from events.
18. **basic18** – `basic18_AsyncRetry` simulating retries with recursion.
19. **basic19** – `basic19_MetricsAggregator` for metric summing.
20. **basic20** – `basic20_CommandLine` parsing CLI options.
21. **basic21** – `basic21_RequestSimulator` for verb/output pairs.
22. **basic22** – `basic22_RouteParser` to extract path tokens.
23. **basic23** – `basic23_LazyTransforms` exploring LazyList pipelines.
24. **basic24** – `basic24_BinaryMask` building alternating bit patterns.
25. **basic25** – `basic25_Scheduler` printing scheduled task runs.
26. **basic26** – `basic26_EventAggregator` counting event occurrences.
27. **basic27** – `basic27_RandomWalk` showing a random stepper.
28. **basic28** – `basic28_TimeSeries` generating simple sequences.
29. **basic29** – `basic29_StringCombiner` concatenating words with delimiters.
30. **basic30** – `basic30_RandomGenerator` printing random numbers.
31. **basic31** – `basic31_SensorCheck` threshold-checking sensor values.
32. **basic32** – `basic32_FibSeries` tail-recursive Fibonacci builder.
33. **basic33** – `basic33_HttpStatus` mapping status codes to text.
34. **basic34** – `basic34_SequenceMatcher` pattern matches on lists.
35. **basic35** – `basic35_ValidationRules` simple length-based guard.
36. **basic36** – `basic36_ConfigPrinter` printing config pairs.
37. **basic37** – `basic37_RangeSummary` computing range min/max.
38. **basic38** – `basic38_RandomSampler` sampling a random element.
39. **basic39** – `basic39_TimeWindow` breaking sequences into sliding windows.
40. **basic40** – `basic40_StringPad` padding strings to a length.
41. **basic41** – `basic41_DataTransformer` uppercasing map values.
42. **basic42** – `basic42_ErrorCounts` counting error strings.
43. **basic43** – `basic43_StreamFilter` filtering LazyList windows.
44. **basic44** – `basic44_MetricScaler` scaling a metric value.
45. **basic45** – `basic45_TimestampUtils` printing the current epoch.
46. **basic46** – `basic46_IdGenerator` producing incremental IDs.
47. **basic47** – `basic47_LabelBuilder` joining segments with '-'.
48. **basic48** – `basic48_KeyValueMerger` merging and bumping values.
49. **basic49** – `basic49_HashPreview` showing a hashCode.
50. **basic50** – `basic50_DebugLogger` printing a debug log.
51. **basic51** – `basic51_SimpleCache` for a one-shot value cache.
52. **basic52** – `basic52_StreamStats` to compute min/max/average from a lazy stream.
53. **basic53** – `basic53_CommandArgs` which parses CLI-style `--key value` pairs.
54. **basic54** – `basic54_TaskQueue` for enqueueing and processing tasks.
55. **basic55** – `basic55_EventDispatcher` to store and call event handlers.
56. **basic56** – `basic56_DataSampler` picking a random sample from a list.
57. **basic57** – `basic57_Timer` measuring how long a block runs.
58. **basic58** – `basic58_NumFilter` filtering odd numbers from a list.
59. **basic59** – `basic59_UrlNormalizer` collapsing redundant slashes.
60. **basic60** – `basic60_MatrixOps` transposing a 2×2 matrix.
61. **basic61** – `basic61_limitedOps` showing take+map on a list.
62. **basic62** – `basic62_sealedFlow` showing a sealed trait + matcher.
63. **basic63** – `basic63_optionFallback` providing defaults via `Option`.
64. **basic64** – `basic64_dataFlow` transforming records through a pipeline.
65. **basic65** – `basic65_retryLoop` simulating retries with recursion.
66. **basic66** – `basic66_eventTimeline` listing event names from timelines.
67. **basic67** – `basic67_validationFlow` combining guards and mod checks.
68. **basic68** – `basic68_lazyCache` demonstrating `lazy val` evaluation.
69. **basic69** – `basic69_aggregator` summing ints from a list.
70. **basic70** – `basic70_msgBuilders` formatting messages.
71. **basic71** – `basic71_CacheUpdater` updating cache entries immutably.
72. **basic72** – `basic72_StateParser` matching simple state strings.
73. **basic73** – `basic73_PathBuilder` joining path segments.
74. **basic74** – `basic74_MetricDiff` computing numeric differences.
75. **basic75** – `basic75_FlagCheck` returning textual flags from booleans.
76. **basic76** – `basic76_StreamingSum` building cumulative sums.
77. **basic77** – `basic77_UserGreeting` generating greetings.
78. **basic78** – `basic78_HeaderBuilder` formatting header strings.
79. **basic79** – `basic79_DelayPrint` invoking thunks for deferred logging.
80. **basic80** – `basic80_CounterFizz` labeling numbers as even/odd.
81. **basic81** – `basic81_StreamInspector` previewing a LazyList‘s first elements.
82. **basic82** – `basic82_StrategySelector` choosing behavior via sealed traits.
83. **basic83** – `basic83_ConfigCombiner` merging configuration maps.
84. **basic84** – `basic84_DelayCache` capturing a lazy value with side effects.
85. **basic85** – `basic85_SignalMonitor` counting signals in a list.
86. **basic86** – `basic86_GuardedLink` demonstrating guard expressions.
87. **basic87** – `basic87_BatchProcessor` logging each batch element.
88. **basic88** – `basic88_Marker` mapping values via `map`.
89. **basic89** – `basic89_KeyLister` printing map keys.
90. **basic90** – `basic90_FinalNote` printing a completion notice.
91. **basic91** – `basic91_PartitionChecker` showing even/odd partitioning.
92. **basic92** – `basic92_LevelReporter` reporting a level string.
93. **basic93** – `basic93_TemplateFiller` formatting templates.
94. **basic94** – `basic94_WindowedSum` computing sliding-window sums.
95. **basic95** – `basic95_CompositeKey` creating dash-separated keys.
96. **basic96** – `basic96_EntryFilter` filtering map entries by value.
97. **basic97** – `basic97_SeqMerger` merging sequences.
98. **basic98** – `basic98_RandomThreshold` labeling random ints.
99. **basic99** – `basic99_RetryPolicy` demonstrating count-down ranges.
100. **basic100** – `basic100_FooterNote` printing the final banner.
71. **basic71** – `basic71_CacheUpdater` updating cache values immutably.
72. **basic72** – `basic72_StateParser` matching state strings with sealed traits.
73. **basic73** – `basic73_PathBuilder` building paths from varargs segments.
74. **basic74** – `basic74_MetricDiff` computing difference between numbers.
75. **basic75** – `basic75_FlagCheck` turning booleans into textual flags.
76. **basic76** – `basic76_StreamingSum` building cumulative sums from a list.
77. **basic77** – `basic77_UserGreeting` generating a simple greeting string.
78. **basic78** – `basic78_HeaderBuilder` printing header key/value pairs.
79. **basic79** – `basic79_DelayPrint` invoking a thunk and printing the result.
80. **basic80** – `basic80_CounterFizz` labeling numbers as even/odd.
61. **basic61** – `basic61_limitedOps` showing take+map on a list.
62. **basic62** – `basic62_sealedFlow` showing a sealed trait + matcher.
63. **basic63** – `basic63_optionFallback` providing default values via `Option`.
64. **basic64** – `basic64_dataFlow` demonstrating record processing pipelines.
65. **basic65** – `basic65_retryLoop` simulating retries with decreasing count.
66. **basic66** – `basic66_eventTimeline` collecting event names in order.
67. **basic67** – `basic67_validationFlow` combining guards with arithmetic.
68. **basic68** – `basic68_lazyCache` using `lazy val` for deferred computation.
69. **basic69** – `basic69_aggregator` summing a list of ints.
70. **basic70** – `basic70_msgBuilders` formatting messages with a prefix.
