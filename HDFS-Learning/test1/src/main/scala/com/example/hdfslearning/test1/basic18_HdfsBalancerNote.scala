package com.example.hdfslearning.test1

object basic18_HdfsBalancerNote {
  def main(args: Array[String]): Unit = {
    println("HDFS Balancer re-distributes blocks for even disk usage across DataNodes.")
    println("Run manually (admin): hdfs balancer -threshold 10")
    println("Set dfs.datanode.balance.bandwidthPerSec to control bandwidth; verify with hdfs dfsadmin -report.")
  }
}
