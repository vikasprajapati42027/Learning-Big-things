# HDFS + Spark Test1

Goal: run small Spark (Scala) jobs that write/read HDFS. Designed for dev laptop (local[*]) against real HDFS or local filesystem fallback.

## Prereqs
- JDK 8+ and sbt installed.
- Spark 3.4.x binaries available (for `spark-submit`) or just use sbt to run the fat jar.
- Access to an HDFS endpoint (set `HDFS_DEMO_FS`), otherwise it falls back to the local filesystem.

## How the demo works
1) Build a SparkSession using master `local[*]`.
2) Determine filesystem URI: environment variable `HDFS_DEMO_FS` (e.g., `hdfs://namenode:8020`) or default `file:///`.
3) Write a small DataFrame of people to Parquet at `${FS}/tmp/hdfs_test1/people_parquet`.
4) Read it back, filter adults, and aggregate a count.
5) Log where the files were written so you can inspect with `hdfs dfs -ls`.

## Run with sbt
```bash
cd HDFS-Learning/test1
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic1_HdfsSparkDemo"
# or rely on local filesystem: sbt "runMain com.example.hdfslearning.test1.basic1_HdfsSparkDemo"

# FileSystem API demo (mkdir, write, list, read)
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic2_HdfsFsOps"

# Append to a file
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic3_HdfsAppend"

# Permissions and ACLs
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic4_HdfsPermissionsAcls"

# File checksum
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic5_HdfsChecksums"

# Block locations for parquet output
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic6_HdfsBlockLocations"

# Replication factor set/read
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic7_HdfsReplication"

# Safe mode status
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic8_HdfsSafeMode"

# Snapshot steps (informational)
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic9_HdfsSnapshotsInfo"

# Quota info and commands (informational)
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic10_HdfsQuotaInfo"

# Rename/move
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic11_HdfsRenameMove"

# Truncate a file
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic12_HdfsTruncate"

# Concatenate files
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic13_HdfsConcat"

# Copy from local and to local
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic14_HdfsCopyFromLocal"
sbt "runMain com.example.hdfslearning.test1.basic15_HdfsCopyToLocal"

# Trash demo
HDFS_DEMO_FS=hdfs://localhost:9000 sbt "runMain com.example.hdfslearning.test1.basic16_HdfsTrash"

# Notes (non-executing admin features)
sbt "runMain com.example.hdfslearning.test1.basic17_HdfsDistcpNote"
sbt "runMain com.example.hdfslearning.test1.basic18_HdfsBalancerNote"
sbt "runMain com.example.hdfslearning.test1.basic19_HdfsEncryptionZoneNote"
sbt "runMain com.example.hdfslearning.test1.basic20_HdfsErasureCodingNote"

# XAttrs, ownership, status, offsets
sbt "runMain com.example.hdfslearning.test1.basic21_HdfsExtendedAttributes"
sbt "runMain com.example.hdfslearning.test1.basic22_HdfsOwnership"
sbt "runMain com.example.hdfslearning.test1.basic23_HdfsFileStatus"
sbt "runMain com.example.hdfslearning.test1.basic24_HdfsOpenAtOffset"

# Notes and utilities
sbt "runMain com.example.hdfslearning.test1.basic25_HdfsLeaseRecoveryNote"
sbt "runMain com.example.hdfslearning.test1.basic26_HdfsRollingUpgradeNote"
sbt "runMain com.example.hdfslearning.test1.basic27_HdfsAuditLogNote"

# Small files mitigation, glob, tail
sbt "runMain com.example.hdfslearning.test1.basic28_HdfsSmallFilesSeqFile"
sbt "runMain com.example.hdfslearning.test1.basic29_HdfsGlobStatus"
sbt "runMain com.example.hdfslearning.test1.basic30_HdfsTail"

# Web/HTTP access and advanced features
sbt "runMain com.example.hdfslearning.test1.basic31_HdfsWebHdfsCurl"
sbt "runMain com.example.hdfslearning.test1.basic32_HdfsHttpFsNote"
sbt "runMain com.example.hdfslearning.test1.basic33_HdfsFsImageBrowseNote"
sbt "runMain com.example.hdfslearning.test1.basic34_HdfsMoverNote"
sbt "runMain com.example.hdfslearning.test1.basic35_HdfsClientRetryConfig"
sbt "runMain com.example.hdfslearning.test1.basic36_HdfsShortCircuitNote"
sbt "runMain com.example.hdfslearning.test1.basic37_HdfsTieredStorageNote"
sbt "runMain com.example.hdfslearning.test1.basic38_HdfsObserverReadsNote"
sbt "runMain com.example.hdfslearning.test1.basic39_HdfsQuotaViolationNote"
sbt "runMain com.example.hdfslearning.test1.basic40_HdfsRouterFederationNote"

# Filesystem utilities and monitoring
sbt "runMain com.example.hdfslearning.test1.basic41_HdfsSetTimes"
sbt "runMain com.example.hdfslearning.test1.basic42_HdfsBufferedRead"
sbt "runMain com.example.hdfslearning.test1.basic43_HdfsRecursiveList"
sbt "runMain com.example.hdfslearning.test1.basic44_HdfsDeleteRecursive"
sbt "runMain com.example.hdfslearning.test1.basic45_HdfsPathExists"
sbt "runMain com.example.hdfslearning.test1.basic46_HdfsSymlinkNote"
sbt "runMain com.example.hdfslearning.test1.basic47_HdfsChecksumCompare"
sbt "runMain com.example.hdfslearning.test1.basic48_HdfsStreamProgress"
sbt "runMain com.example.hdfslearning.test1.basic49_HdfsTmpWorkflow"
sbt "runMain com.example.hdfslearning.test1.basic50_HdfsMetricsJmxNote"
```

## Inspect the output (HDFS)
```bash
hdfs dfs -ls   /tmp/hdfs_test1/people_parquet
hdfs dfs -ls   /tmp/hdfs_test1/people_parquet/_SUCCESS
hdfs dfs -cat  /tmp/hdfs_test1/people_parquet/part-*.parquet   # for a quick check use parquet-tools instead
```

## Inspect the output (local fallback)
```bash
ls /tmp/hdfs_test1/people_parquet
```

## What to mention in an interview
- Show you know how Spark discovers the default FS via `fs.defaultFS` and how to override it per job.
- Emphasize write-once/append semantics of HDFS and Parquet columnar benefits.
- Highlight locality: Spark will prefer block-local reads when running on YARN/cluster; on local mode you just see file:// paths.
- Describe failure handling: if a DataNode fails during write, the client re-pipelines to a new DN to maintain replication.
