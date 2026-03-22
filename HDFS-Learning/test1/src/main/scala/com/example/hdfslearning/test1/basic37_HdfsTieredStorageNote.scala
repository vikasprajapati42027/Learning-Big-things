package com.example.hdfslearning.test1

object basic37_HdfsTieredStorageNote {
  def main(args: Array[String]): Unit = {
    println("Tiered storage uses multiple storage types (DISK, SSD, ARCHIVE).")
    println("Assign with dfs.datanode.data.dir specifying [DISK], [SSD], [ARCHIVE]; set storage policies per path.")
    println("Mover aligns blocks to policies; monitor with hdfs dfsadmin -report.")
  }
}
