package com.example.hdfslearning.test1

object basic26_HdfsRollingUpgradeNote {
  def main(args: Array[String]): Unit = {
    println("Rolling upgrades allow HDFS version upgrades without full downtime.")
    println("Admin flow: hdfs dfsadmin -rollingUpgrade prepare | query | finalize")
    println("Clients should support downgrade if finalize not completed.")
  }
}
