# HDFS Learning

## Basic1: HDFS fundamentals
- **What is HDFS?** A distributed, fault‑tolerant filesystem optimized for large, streaming reads and high write throughput; separates metadata (NameNode) from data (DataNodes).
- **Block size**: Default 128 MB (64 MB on older releases). Files are split into blocks and distributed to balance IO.
- **Replication**: Default factor 3; ensures durability and data locality. Each block replica is placed across racks when rack awareness is configured.
- **NameNode roles**: Active manages namespace & block map; Standby (in HA setups) takes over during failover. Edit log + fsimage form the namespace state.
- **DataNode role**: Stores block replicas; sends heartbeats and block reports to the NameNode.
- **Write path (high level)**: Client asks NameNode for block locations → pipeline to DataNodes → packet streaming with checksum → acknowledgments flow back up the pipeline.
- **Read path (high level)**: Client requests block locations from NameNode → reads nearest replica directly from DataNodes.
- **Consistency model**: Write‑once, append‑many; no in‑place updates. Client‑side buffering; data visible after `hflush()` / `hsync()`.
- **High availability**: Uses ZooKeeper + ZKFC for automatic failover; shared edits (QJM) keep Active/Standby in sync.
- **Security**: Kerberos for auth; HDFS permissions/ACLs for authorization; encryption at rest (TDE) and in transit (DataTransferProtocol with TLS).

## Quick commands (local pseudo‑cluster)
```bash
# format NameNode (first time only)
hdfs namenode -format
# start daemons (on dev boxes)
start-dfs.sh
# basic operations
hdfs dfs -mkdir -p /data/demo
hdfs dfs -put localfile.txt /data/demo/
hdfs dfs -ls /data/demo
hdfs dfs -cat /data/demo/localfile.txt
# stop daemons
stop-dfs.sh
```

## Interview‑style Q&A (short form)
1. **Why large block sizes?** Fewer blocks → smaller metadata footprint and less seek overhead; favors streaming IO over random IO.
2. **Difference between `hflush()` and `hsync()`?** `hflush` flushes data to DataNodes; `hsync` also persists block length metadata so readers see exact length.
3. **What happens when a DataNode fails?** NameNode marks replicas under‑replicated; BlockManager schedules new replicas to other DataNodes to restore the replication factor.
4. **How are replicas placed across racks?** First replica on local node (writer), second on a different rack, third on the same rack as the second (default rack‑aware policy).
5. **Can HDFS overwrite a file?** No in‑place overwrite; you write new files or append. Truncate is supported in modern versions but is limited.
6. **What is a safemode?** A NameNode state during startup where it waits for enough block reports; no writes allowed until exiting safemode.
7. **How does HA failover work?** ZKFC monitors Active/Standby; on failure it uses ZooKeeper for fencing/coordination, Standby loads the latest edits and becomes Active.
8. **What is the Secondary NameNode?** Misnamed helper that periodically checkpoints (merges fsimage + edits) to reduce NameNode startup time; not a hot standby.
9. **How does checksum verification work?** Clients compute checksums per chunk (default 512 bytes) when writing; DataNodes verify on receive and again on read.
10. **How to secure multi‑tenant clusters?** Enable Kerberos, set permissions/ACLs, use TDE for directories, and TLS for data transfer; optionally integrate Ranger/Sentry for fine‑grained policies.

## Mini hands‑on test
- Create a 1 GB file locally, put it to HDFS, and confirm the replication factor:
  ```bash
  dd if=/dev/zero of=/tmp/gbfile bs=64M count=16
  hdfs dfs -put /tmp/gbfile /data/demo/gbfile
  hdfs fsck /data/demo/gbfile -files -blocks -locations
  ```
- Simulate DataNode loss by stopping one DN; run `hdfs fsck` again and watch re‑replication in the report.
