# Spark Learning Test1

## Overview

This module introduces a minimal Spark demo using Scala and sbt. `basic1_BasicSparkExample` boots a `SparkSession`, creates a tiny dataset, and applies simple transformations; `basic2_SparkWordCount` runs a tiny word-count pipeline to illustrate `DataFrame` APIs. Additional lessons demonstrate aggregations, joins, UDFs, partitioning, caching, window functions, strong typing, SQL views, JSON loading, parquet writes, broadcast joins, accumulators, pivots, sampling, repartitioning, and quantiles.

## Run

```bash
cd Spark-Learning/test1
sbt "runMain com.example.sparklearning.test1.basic1_BasicSparkExample"
Swap the `runMain` argument to any `basicN_*` from `basic1` through `basic100` to explore that lesson.

### Lesson index
- `basic1_BasicSparkExample`: build a DataFrame, derive columns, and filter rows.
- `basic2_SparkWordCount`: tiny word count with explode + groupBy.
- `basic3_SparkAggregations`: sum/avg aggregations by key.
- `basic4_SparkJoins`: simple left join between two DataFrames.
- `basic5_SparkUdf`: register a UDF to tag rows.
- `basic6_SparkPartitioning`: inspect partition counts after repartition.
- `basic7_SparkCaching`: cache and reuse a DataFrame.
- `basic8_SparkWindow`: window functions with dense_rank per group.
- `basic9_SparkDataset`: typed Dataset with case class `Event`.
- `basic10_SparkSql`: create temp view and run SQL.
- `basic11_SparkJsonLoad`: read JSON lines from an in-memory RDD.
- `basic12_SparkParquetWrite`: write/read parquet to a local path.
- `basic13_SparkBroadcastJoin`: broadcast a small dimension table.
- `basic14_SparkAccumulator`: use an accumulator inside actions.
- `basic15_SparkMapPartitions`: inspect partition sizes via mapPartitions.
- `basic16_SparkPivot`: pivot quarterly revenue by region.
- `basic17_SparkExplainPlan`: display a formatted physical plan.
- `basic18_SparkSample`: sample a fraction of rows deterministically.
- `basic19_SparkRepartition`: compare repartition vs coalesce counts.
- `basic20_SparkApproxQuantile`: compute approximate quantiles on a column.
- `basic21_SparkKafkaSchema`: define a schema for Kafka value payloads.
- `basic22_SparkCheckpoint`: set checkpoint dir and materialize an RDD.
- `basic23_SparkBroadcastVar`: broadcast a lookup map and use it in an RDD.
- `basic24_SparkSkewHint`: aggregate skewed keys and view the plan.
- `basic25_SparkWindowLag`: use window `lag` to compare previous rows.
- `basic26_SparkRangeJoin`: join events against value ranges.
- `basic27_SparkBucketedWrite`: write a bucketed table (requires metastore).
- `basic28_SparkBloomFilter`: build a Bloom filter and test membership.
- `basic29_SparkUDAF`: custom aggregation to compute average string length.
- `basic30_SparkDeltaLikeMerge`: full-outer merge to simulate upserts.
- `basic31_SparkCubeRollup`: compare rollup vs cube multi-level aggregates.
- `basic32_SparkDropDuplicates`: contrast `distinct` vs `dropDuplicates` by key.
- `basic33_SparkRepartitionByRange`: range partition a DataFrame on a column.
- `basic34_SparkCollectList`: collect grouped values into arrays.
- `basic35_SparkRandomSplit`: split a dataset into train/test parts.
- `basic36_SparkUnionByName`: union frames that have different column orders.
- `basic37_SparkPersistLevels`: set an explicit storage level and inspect it.
- `basic38_SparkDatasetMap`: map a Dataset to a typed case class.
- `basic39_SparkApproxCountDistinct`: approximate distinct count with error bound.
- `basic40_SparkJoinHint`: broadcast hint on a join to influence the plan.
- `basic41_SparkCrossJoin`: explicit cross join of two DataFrames.
- `basic42_SparkCartesianProduct`: cartesian product example with small inputs.
- `basic43_SparkCacheVsPersist`: contrast cache vs persist storage levels.
- `basic44_SparkForeachPartition`: per-partition side effects with foreachPartition.
- `basic45_SparkCsvOptions`: write CSV with header/quote/escape options.
- `basic46_SparkJsonExplode`: explode arrays from JSON payloads.
- `basic47_SparkWithColumns`: add multiple derived columns at once.
- `basic48_SparkSQLFunctions`: lower/upper/length string functions demo.
- `basic49_SparkCoalesceNulls`: coalesce nullable columns into one.
- `basic50_SparkJsonToStruct`: parse JSON strings into typed struct columns.
- `basic51_SparkBucketedRead`: inspect bucketed table presence (from basic27).
- `basic52_SparkStructOps`: build/select from struct columns.
- `basic53_SparkArrayOps`: array size and membership helpers.
- `basic54_SparkMapTypeOps`: map keys and item access.
- `basic55_SparkWindowLead`: use `lead` in a window to peek forward.
- `basic56_SparkMedianApprox`: approximate median via `percentile_approx`.
- `basic57_SparkSessionConf`: read session conf like shuffle partitions.
- `basic58_SparkCacheTable`: cache a temp view and verify cached status.
- `basic59_SparkFileSourceOptions`: inspect data source environment info.
- `basic60_SparkExplainCost`: show cost-based plan details.
- `basic61_SparkTempViewVsGlobal`: create and query a temp view.
- `basic62_SparkRangeFilter`: filter rows using `between`.
- `basic63_SparkRegexFilter`: filter strings with regex.
- `basic64_SparkDatetimeOps`: parse dates and extract year/month.
- `basic65_SparkNullHandling`: fill nulls with `coalesce`.
- `basic66_SparkOrderByDesc`: order results descending on a column.
- `basic67_SparkRepartitionColumns`: repartition DataFrame by column values.
- `basic68_SparkPivotCount`: pivot and count occurrences by code.
- `basic69_SparkNaFill`: fill nullable columns via `na.fill`.
- `basic70_SparkDropColumns`: drop unwanted columns from a DataFrame.
- `basic71_SparkBucketByColumns`: bucket output by column; requires metastore.
- `basic72_SparkSkewJoinHint`: skew join hint for hotspot keys.
- `basic73_SparkCheckpointDF`: checkpoint a DataFrame.
- `basic74_SparkSortWithinPartitions`: sort records within each partition.
- `basic75_SparkReplaceWhere`: overwrite partition path with replaceWhere.
- `basic76_SparkBucketHint`: BUCKET plan hint example.
- `basic77_SparkParallelizePairs`: reduceByKey on pair RDDs.
- `basic78_SparkAccumulatorDouble`: double accumulator over an RDD.
- `basic79_SparkZipWithIndex`: zip data with monotonically increasing index.
- `basic80_SparkLookupJoin`: broadcast lookup join for small dims.
- `basic81_SparkColumnAliases`: rename selected columns with aliases.
- `basic82_SparkCaseWhen`: conditional column creation with when/otherwise.
- `basic83_SparkWindowPercentRank`: percent_rank window function.
- `basic84_SparkUdfNullSafe`: null-safe UDF upper-casing.
- `basic85_SparkJoinMultiple`: chain multiple left joins.
- `basic86_SparkCartesianLimit`: limit results after cross join.
- `basic87_SparkBroadcastNested`: broadcast join with nested plan explain.
- `basic88_SparkSessionCatalog`: list databases and tables.
- `basic89_SparkMemoryUsage`: show executor memory conf if set.
- `basic90_SparkUDAFTyped`: typed Aggregator UDAF computing avg length.
- `basic91_SparkDatasetFilter`: filter a typed Dataset.
- `basic92_SparkDatasetGroupBy`: groupByKey on a Dataset.
- `basic93_SparkDatasetJoin`: join two Datasets converted to DataFrames.
- `basic94_SparkDatasetEncoders`: custom encoder for a case class Dataset.
- `basic95_SparkDatasetMapPartitions`: inspect partition sizes in a Dataset.
- `basic96_SparkDatasetReduce`: reduce over a Dataset to a single value.
- `basic97_SparkDatasetFlatMap`: flatMap Dataset rows into tokens.
- `basic98_SparkDatasetCoalesce`: shrink partitions via coalesce.
- `basic99_SparkDatasetCheckpoint`: checkpoint a Dataset.
- `basic100_SparkDatasetSample`: sample a Dataset with a fixed seed.
```
