# Spark Learning Test2

## Overview
Second Spark lab with numbered `basicN_` demos. Start with `basic1_SparkDatasetBasics` to see Dataset creation, simple transforms, and actions. `basic2_SparkDataframeJoins` shows a left join between users and orders. Lessons up to `basic10` add aggregations, SQL temp views, parquet/csv IO, UDFs, window functions, broadcast joins, and plan explain.

## Run
```bash
cd Spark-Learning/test2
sbt "runMain com.example.sparklearning.test2.basic1_SparkDatasetBasics"
```
Swap `runMain` to any added `basicN_` lesson (e.g., `basic10_SparkExplain`).

### Lesson index
- `basic1_SparkDatasetBasics`: typed Dataset creation, filter, select.
- `basic2_SparkDataframeJoins`: left join users to orders.
- `basic3_SparkAggregations`: groupBy sum/avg.
- `basic4_SparkSqlTempView`: temp view + SQL query.
- `basic5_SparkParquetIO`: write/read parquet locally.
- `basic6_SparkCsvRead`: write sample CSV then read with header.
- `basic7_SparkUdf`: simple UDF for uppercasing.
- `basic8_SparkWindow`: dense_rank window per user.
- `basic9_SparkJoinBroadcast`: broadcast dim table in a join.
- `basic10_SparkExplain`: show physical plan with explain(true).
- `basic11_SparkCachePersist`: cache vs persist; storage levels; unpersist.
- `basic12_SparkPartitioning`: repartition/coalesce; estimating partitions; shuffle cost.
- `basic13_SparkSkewHandling`: skew hints, salting, skew join handling.
- `basic14_SparkBucketing`: bucketed tables; join performance; bucketBy + saveAsTable.
- `basic15_SparkExplainAQE`: adaptive query execution; skew/join re-optimization.
- `basic16_SparkBroadcastHints`: manual broadcast hints vs auto broadcast; size thresholds.
- `basic17_SparkCheckpointing`: checkpoint vs cache; state reset; where to store checkpoints.
- `basic18_SparkStructuredStreamingIntro`: micro-batch vs continuous; simple file source + console sink.
- `basic19_SparkStructuredStreamingWatermark`: event-time window agg with watermark and late data.
- `basic20_SparkDeltaBasics`: Delta Lake ACID writes, merges, time travel (if delta-core available).
- `basic21_SparkStructuredStreamingKafka`: Kafka source/sink, checkpoint location, exactly-once semantics caveats.
- `basic22_SparkStreamingStateful`: mapGroupsWithState/flatMapGroupsWithState for sessionization.
- `basic23_SparkStreamingTriggers`: fixed vs once vs continuous triggers; latency trade-offs.
- `basic24_SparkMlFeatureEng`: VectorAssembler, StringIndexer, OneHotEncoder, Pipeline.
- `basic25_SparkMlClassification`: logistic regression example with train/validation split and evaluator metrics.
- `basic26_SparkMlTuning`: ParamGridBuilder + CrossValidator; overfitting detection.
- `basic27_SparkMlModelIO`: save/load Pipelines and Models; versioning considerations.
- `basic28_SparkGraphXIntro`: basic graph creation, PageRank, connected components.
- `basic29_SparkAccumulatorsMetrics`: accumulators vs broadcast vars; custom metrics with Dropwizard/StatsD.
- `basic30_SparkPerfTuning`: executor/cores/memory sizing, parallelism, GC hints, shuffle service, speculative execution.
- `basic31_SparkStructuredStreamingUdf`: using Python/Scala UDFs in streaming with serialization caveats.
- `basic32_SparkJoinHintsAdvanced`: hint syntax combos; cost pitfalls; avoiding hint conflicts.
- `basic33_SparkAdaptiveShuffle`: AQE shuffle repartition coalescing; debugging with UI/explain.
- `basic34_SparkFilesBroadcast`: distributing side data via `SparkFiles` vs broadcast; size limits.
- `basic35_SparkArrowPandas`: pandas UDFs/UDTs; Arrow configs; batch sizing impact.
- `basic36_SparkIcebergIntro`: Iceberg table creation, writes, time travel (if dep present).
- `basic37_SparkDeltaOptimizeZOrder`: OPTIMIZE/ZORDER concepts; file pruning; caveats (needs delta).
- `basic38_SparkPhotonVectorized`: enabling vectorized reader; Parquet/ORC options; predicate pushdown.
- `basic39_SparkSecurityBasics`: ACLs, Ranger/Sentry mention, encrypting at rest/in transit.
- `basic40_SparkDebugging`: using Spark UI/event logs, stage DAGs, common failure patterns.
