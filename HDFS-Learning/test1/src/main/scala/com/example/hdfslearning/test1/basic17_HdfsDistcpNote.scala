package com.example.hdfslearning.test1

object basic17_HdfsDistcpNote {
  def main(args: Array[String]): Unit = {
    println("DistCp is a MapReduce job for large-scale copies between clusters or within HDFS.")
    println("Typical usage:")
    println("  hadoop distcp hdfs://src-cluster:8020/path hdfs://dest-cluster:8020/path")
    println("Use -update/-overwrite/-delete flags and consider -bandwidth for throttling.")
  }
}
