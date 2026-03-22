package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic80_SparkDeltaRetention {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic80_SparkDeltaRetention").master("local[*]").getOrCreate()
    println("Delta log retention/cleanup requires delta-core; configure delta.logRetentionDuration and checkpointRetentionDuration when using Delta.")
    spark.stop()
  }
}
