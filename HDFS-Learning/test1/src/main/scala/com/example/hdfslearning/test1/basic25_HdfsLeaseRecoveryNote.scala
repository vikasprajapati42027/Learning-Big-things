package com.example.hdfslearning.test1

object basic25_HdfsLeaseRecoveryNote {
  def main(args: Array[String]): Unit = {
    println("Lease recovery is triggered when a writer dies holding a file lease.")
    println("Admins can force recovery: hdfs debug recoverLease -path /path/to/file")
    println("Or use hdfs dfs -recoverLease /path/to/file")
    println("Spark jobs typically rely on automatic lease recovery after dfs.namenode.lease-recheck-interval expires.")
  }
}
