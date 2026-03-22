# Hive Learning Test1

Goal: Run a small Spark (Scala) job with Hive support that:
- Uses HDFS (or local) as storage.
- Creates a managed Hive table, inserts data, queries it with SQL.
- Demonstrates reading/writing Parquet to HDFS.

## Prereqs
- JDK 8+ and sbt installed.
- Spark 3.4.x with hive support (spark-hive) available.
- Hive metastore reachable (local Derby for dev, or external). Set `HIVE_WAREHOUSE` if you want a custom location.
- HDFS endpoint optional; default falls back to local filesystem via `file:///`.

## Run
```bash
cd Hive-Learning/test1
HDFS_DEMO_FS=hdfs://localhost:9000 \
HIVE_WAREHOUSE=/user/hive/warehouse \
sbt "runMain com.example.hivelearning.test1.basic1_HiveSparkDemo"

# External partitioned table demo
HDFS_DEMO_FS=hdfs://localhost:9000 \
HIVE_WAREHOUSE=/user/hive/warehouse \
sbt "runMain com.example.hivelearning.test1.basic2_HiveExternalPartitioned"

# Bucketed table
sbt "runMain com.example.hivelearning.test1.basic3_HiveBucketedTable"

# ORC table
sbt "runMain com.example.hivelearning.test1.basic4_HiveOrcTable"

# Temp vs global temp views
sbt "runMain com.example.hivelearning.test1.basic5_HiveTempViews"

# Dynamic partition insert
sbt "runMain com.example.hivelearning.test1.basic6_HiveDynamicPartitionInsert"

# LOAD DATA example
sbt "runMain com.example.hivelearning.test1.basic7_HiveLoadData"

# UDF usage
sbt "runMain com.example.hivelearning.test1.basic8_HiveUdf"

# Analyze statistics
sbt "runMain com.example.hivelearning.test1.basic9_HiveAnalyzeStats"

# Explain formatted
sbt "runMain com.example.hivelearning.test1.basic10_HiveExplainFormatted"

# ACID merge (ORC transactional)
sbt "runMain com.example.hivelearning.test1.basic11_HiveAcidMerge"

# Views
sbt "runMain com.example.hivelearning.test1.basic12_HiveView"

# Compression settings
sbt "runMain com.example.hivelearning.test1.basic13_HiveCompressTable"

# CBO explain
sbt "runMain com.example.hivelearning.test1.basic14_HiveExplainCbo"

# JSON SerDe
sbt "runMain com.example.hivelearning.test1.basic15_HiveSerdeJson"

# Avro table
sbt "runMain com.example.hivelearning.test1.basic16_HiveAvroTable"

# Insert overwrite directory
sbt "runMain com.example.hivelearning.test1.basic17_HiveInsertOverwriteDir"

# CTAS
sbt "runMain com.example.hivelearning.test1.basic18_HiveCTAS"

# Join optimizations (mapjoin)
sbt "runMain com.example.hivelearning.test1.basic19_HiveJoinOptimizations"

# ACID maintenance note
sbt "runMain com.example.hivelearning.test1.basic20_HiveTxnCleanupNote"

# Lateral view explode
sbt "runMain com.example.hivelearning.test1.basic21_HiveLateralViewExplode"

# Window functions
sbt "runMain com.example.hivelearning.test1.basic22_HiveWindowFunctions"

# Skew hint
sbt "runMain com.example.hivelearning.test1.basic23_HiveSkewHint"

# Vectorized ORC read
sbt "runMain com.example.hivelearning.test1.basic24_HiveVectorizedOrc"

# Notes: Tez, LLAP, MVs, Ranger/Sentry, concurrency, bucketing vs partitioning
sbt "runMain com.example.hivelearning.test1.basic25_HiveTezNote"
sbt "runMain com.example.hivelearning.test1.basic26_HiveLLAPNote"
sbt "runMain com.example.hivelearning.test1.basic27_HiveMaterializedViewNote"
sbt "runMain com.example.hivelearning.test1.basic28_HiveRangerSentryNote"
sbt "runMain com.example.hivelearning.test1.basic29_HiveConcurrencyNote"
sbt "runMain com.example.hivelearning.test1.basic30_HiveBucketingVsPartitioningNote"

# Spark-side broadcast join, catalogs, configs, table properties
sbt "runMain com.example.hivelearning.test1.basic31_HiveBroadcastJoinSpark"
sbt "runMain com.example.hivelearning.test1.basic32_HiveSparkCatalogs"
sbt "runMain com.example.hivelearning.test1.basic33_HiveSetVsConfig"
sbt "runMain com.example.hivelearning.test1.basic34_HiveTableProperties"
sbt "runMain com.example.hivelearning.test1.basic35_HiveSerdeRegex"

# Partition pruning and schema evolution
sbt "runMain com.example.hivelearning.test1.basic36_HivePartitionPruning"
sbt "runMain com.example.hivelearning.test1.basic37_HiveOrcAcidCompactionNote"
sbt "runMain com.example.hivelearning.test1.basic38_HiveSchemaEvolutionOrc"

# UDAF and table format note
sbt "runMain com.example.hivelearning.test1.basic39_HiveUserDefinedAggregation"
sbt "runMain com.example.hivelearning.test1.basic40_HiveIcebergNote"

# CTE, pivot, map explode, collect_list
sbt "runMain com.example.hivelearning.test1.basic41_HiveCte"
sbt "runMain com.example.hivelearning.test1.basic42_HivePivot"
sbt "runMain com.example.hivelearning.test1.basic43_HiveExplodeMap"
sbt "runMain com.example.hivelearning.test1.basic44_HiveCollectList"

# Notes and misc optimizations
sbt "runMain com.example.hivelearning.test1.basic45_HiveBloomFilterNote"
sbt "runMain com.example.hivelearning.test1.basic46_HiveExportImportNote"
sbt "runMain com.example.hivelearning.test1.basic47_HiveShowGrantsNote"
sbt "runMain com.example.hivelearning.test1.basic48_HiveMergeSmallFilesNote"

# Partition pruning, schema evolution, UDAF, Iceberg note already above
sbt "runMain com.example.hivelearning.test1.basic36_HivePartitionPruning"
sbt "runMain com.example.hivelearning.test1.basic38_HiveSchemaEvolutionOrc"
sbt "runMain com.example.hivelearning.test1.basic49_HiveTableSizeEstimation"
sbt "runMain com.example.hivelearning.test1.basic50_HiveSessionStateNote"

# Date/time, unions, regex, set aggregations
sbt "runMain com.example.hivelearning.test1.basic51_HiveDateFunctions"
sbt "runMain com.example.hivelearning.test1.basic52_HiveUnionAll"
sbt "runMain com.example.hivelearning.test1.basic53_HiveCaseWhen"
sbt "runMain com.example.hivelearning.test1.basic54_HiveRegexpFunctions"
sbt "runMain com.example.hivelearning.test1.basic55_HiveCollectSet"

# Join/bucketing notes and maintenance
sbt "runMain com.example.hivelearning.test1.basic56_HiveBucketSortMergeJoinNote"
sbt "runMain com.example.hivelearning.test1.basic57_HiveSkewJoinSettings"
sbt "runMain com.example.hivelearning.test1.basic58_HiveCompressionCodecs"
sbt "runMain com.example.hivelearning.test1.basic59_HiveMSCKRepairVsAddPartition"
sbt "runMain com.example.hivelearning.test1.basic60_HiveViewAuthorizationNote"

# Arrays/maps/structs, bucketed join, session UDF
sbt "runMain com.example.hivelearning.test1.basic61_HiveArrayContains"
sbt "runMain com.example.hivelearning.test1.basic62_HiveMapFromEntries"
sbt "runMain com.example.hivelearning.test1.basic63_HiveStructField"
sbt "runMain com.example.hivelearning.test1.basic64_HiveBucketedJoinExample"
sbt "runMain com.example.hivelearning.test1.basic65_HiveSessionUdfTempFunction"

# More array/map helpers
sbt "runMain com.example.hivelearning.test1.basic66_HiveArrayJoin"
sbt "runMain com.example.hivelearning.test1.basic67_HiveArrayIntersect"
sbt "runMain com.example.hivelearning.test1.basic68_HiveArrayPosition"
sbt "runMain com.example.hivelearning.test1.basic69_HiveMapKeysValues"
sbt "runMain com.example.hivelearning.test1.basic70_HiveSortArray"
# omit env vars to use local filesystem and default warehouse in the workdir
```

## What it does
1) Builds a `SparkSession` with `.enableHiveSupport()`, sets `spark.sql.warehouse.dir` and default FS.
2) Creates a database `demo_db` if missing.
3) Creates a managed table `demo_db.people` (Parquet).
4) Inserts sample rows, then runs a SQL query.
5) Writes the result to `${fs}/tmp/hive_test1/people_out` in Parquet.

`basic2_HiveExternalPartitioned`:
- Creates an external, partitioned table `demo_db.ext_sales` at `${fs}/tmp/hive_test1/ext_sales`.
- Writes sample partitioned Parquet data, runs `MSCK REPAIR TABLE`, and aggregates by partition key `dt`.

`basic3_HiveBucketedTable`:
- Buckets a Parquet table (`bucketed_users`) on `id` with 2 buckets and sorts by `id`.

`basic4_HiveOrcTable`:
- Creates ORC table `orc_products`, inserts rows, and selects.

`basic5_HiveTempViews`:
- Shows scope differences between temp view and global temp view (`global_temp` db).

`basic6_HiveDynamicPartitionInsert`:
- Dynamic partition insert into external Parquet table `dyn_sales` with partition column `region`.

`basic7_HiveLoadData`:
- Demonstrates `LOAD DATA LOCAL INPATH` into a textfile table.

`basic8_HiveUdf`:
- Registers a Scala UDF and uses it in SQL over a Hive Parquet table.

`basic9_HiveAnalyzeStats`:
- Runs `ANALYZE TABLE ... COMPUTE STATISTICS` and column stats.

`basic10_HiveExplainFormatted`:
- Shows an `EXPLAIN FORMATTED` plan on a simple filter query.

`basic11_HiveAcidMerge`:
- ORC transactional table with MERGE INTO for updates/inserts.

`basic12_HiveView`:
- Creates a view over a base table for adults.

`basic13_HiveCompressTable`:
- Enables Snappy output compression for Hive writes.

`basic14_HiveExplainCbo`:
- Enables Hive CBO and shows EXPLAIN EXTENDED using stats.

`basic15_HiveSerdeJson`:
- JSON SerDe table on text storage.

`basic16_HiveAvroTable`:
- Avro SerDe/table with inline schema literal.

`basic17_HiveInsertOverwriteDir`:
- `INSERT OVERWRITE DIRECTORY` storing Parquet to a target path.

`basic18_HiveCTAS`:
- CTAS to build `ctas_adults` from `ctas_people`.

`basic19_HiveJoinOptimizations`:
- Demonstrates mapjoin/autoconvert small table with EXPLAIN.

`basic20_HiveTxnCleanupNote`:
- Notes on compaction/cleanup for ACID tables.

`basic21_HiveLateralViewExplode`:
- Explodes array column with LATERAL VIEW.

`basic22_HiveWindowFunctions`:
- Windowed aggregates (sum, rank) over Hive table.

`basic23_HiveSkewHint`:
- Uses SKEW hint in a GROUP BY example.

`basic24_HiveVectorizedOrc`:
- Demonstrates vectorized ORC reader with predicate pushdown.

`basic25_HiveTezNote` / `basic26_HiveLLAPNote`:
- Engine notes for Tez and LLAP (informational).

`basic27_HiveMaterializedViewNote`:
- MV rewrite reminder and Spark/Hive interoperability caution.

`basic28_HiveRangerSentryNote`:
- Authorization integration note.

`basic29_HiveConcurrencyNote`:
- Locking/concurrency considerations for ACID.

`basic30_HiveBucketingVsPartitioningNote`:
- When to use partitions vs buckets.

`basic31_HiveBroadcastJoinSpark`:
- Broadcast join via Spark over Hive tables; shows explain and threshold config.

`basic32_HiveSparkCatalogs`:
- Lists catalogs, databases, and tables via Spark catalog API.

`basic33_HiveSetVsConfig`:
- Demonstrates `SET` outputs for Hive and Spark configs.

`basic34_HiveTableProperties`:
- Creates table with custom TBLPROPERTIES and inspects with DESCRIBE EXTENDED.

`basic35_HiveSerdeRegex`:
- RegexSerDe text table parsing three fields.

`basic36_HivePartitionPruning`:
- External partitioned table, REPAIR TABLE, and EXPLAIN for pruning/DPP.

`basic37_HiveOrcAcidCompactionNote`:
- Note on compaction for ORC ACID tables.

`basic38_HiveSchemaEvolutionOrc`:
- ORC schema evolution via ALTER TABLE ADD COLUMNS.

`basic39_HiveUserDefinedAggregation`:
- Spark UDAF registered and used in SQL.

`basic40_HiveIcebergNote`:
- Iceberg/Hive catalog integration note.

`basic41_HiveCte`:
- Common Table Expression usage with STACK.

`basic42_HivePivot`:
- PIVOT aggregate to widen year values.

`basic43_HiveExplodeMap`:
- LATERAL VIEW explode on MAP<STRING,STRING>.

`basic44_HiveCollectList`:
- Aggregates actions into array via collect_list.

`basic45_HiveBloomFilterNote`:
- Bloom filter table properties for ORC.

`basic46_HiveExportImportNote`:
- EXPORT/IMPORT commands for non-ACID migration.

`basic47_HiveShowGrantsNote`:
- SHOW GRANT usage reminder.

`basic48_HiveMergeSmallFilesNote`:
- Settings to merge small files.

`basic49_HiveTableSizeEstimation`:
- Uses ANALYZE/describe formatted to inspect table size/stats.

`basic50_HiveSessionStateNote`:
- Spark Hive catalog/session state awareness when mixing sources.

`basic51_HiveDateFunctions`:
- Demonstrates common date/time functions.

`basic52_HiveUnionAll`:
- UNION ALL example with CTE.

`basic53_HiveCaseWhen`:
- CASE WHEN parity example.

`basic54_HiveRegexpFunctions`:
- regexp_replace and regexp_extract usage.

`basic55_HiveCollectSet`:
- collect_set aggregation for distinct values.

`basic56_HiveBucketSortMergeJoinNote`:
- Note on bucketed sort-merge/bucket map joins.

`basic57_HiveSkewJoinSettings`:
- Settings for Hive skew join handling.

`basic58_HiveCompressionCodecs`:
- Common compression configs for Hive/ORC/Parquet.

`basic59_HiveMSCKRepairVsAddPartition`:
- Guidance on REPAIR TABLE vs ADD PARTITION.

`basic60_HiveViewAuthorizationNote`:
- View authorization considerations with Ranger/Sentry.

`basic61_HiveArrayContains`:
- ARRAY_CONTAINS on array column.

`basic62_HiveMapFromEntries`:
- Build map from key/value structs.

`basic63_HiveStructField`:
- Create and access struct fields.

`basic64_HiveBucketedJoinExample`:
- Bucketed tables joined with BUCKET hint.

`basic65_HiveSessionUdfTempFunction`:
- Register Spark UDF for use in Hive-compatible SQL.

`basic66_HiveArrayJoin`:
- `array_join` to concatenate array elements.

`basic67_HiveArrayIntersect`:
- Intersection of two arrays.

`basic68_HiveArrayPosition`:
- Position lookup in an array.

`basic69_HiveMapKeysValues`:
- Extract keys and values from a map.

`basic70_HiveSortArray`:
- Sort an array.

## Inspection (HDFS)
```bash
hdfs dfs -ls /user/hive/warehouse/demo_db.db/people
hdfs dfs -ls /tmp/hive_test1/people_out
```

## Interview talking points
- Why `enableHiveSupport()` is needed for catalog + metastore-backed tables.
- Difference between managed vs external tables; warehouse location and default FS.
- Spark uses its own execution engine even when using Hive tables (no MapReduce unless hive.execution.engine is changed).
- Partitioning and bucketing could be added for larger datasets; Parquet as default storage.
