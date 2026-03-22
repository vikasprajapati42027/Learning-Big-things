package com.example.hivelearning.test1

object basic26_HiveLLAPNote {
  def main(args: Array[String]): Unit = {
    println("Hive LLAP provides low-latency queries via persistent daemons and caching.")
    println("Enable with hive.execution.engine=tez and llap settings; Spark won't use LLAP, but HiveServer2 queries can.")
  }
}
