package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic65_SparkBroadcastTimeout {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic65_SparkBroadcastTimeout")
      .master("local[*]")
      .config("spark.sql.broadcastTimeout", "300")
      .getOrCreate()

    println("Broadcast timeout configured to 300s; adjust for large broadcasts.")
    spark.stop()
  }
}
