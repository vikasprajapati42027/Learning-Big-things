package com.example.hivelearning.test1

object basic25_HiveTezNote {
  def main(args: Array[String]): Unit = {
    println("Hive on Tez: set hive.execution.engine=tez and ensure Tez libs are available on the cluster.")
    println("In Spark SQL, Tez is not used; Spark provides its own engine. This note is informational.")
  }
}
