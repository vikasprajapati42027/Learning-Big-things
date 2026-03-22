package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic60_SparkSessionConfigs {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic60_SparkSessionConfigs")
      .master("local[*]")
      .config("spark.sql.shuffle.partitions", "8")
      .config("spark.sql.autoBroadcastJoinThreshold", 50 * 1024 * 1024)
      .getOrCreate()

    println("Spark session started with custom configs; adjust for your workload.")
    spark.stop()
  }
}
