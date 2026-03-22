package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic30_SparkPerfTuning {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic30_SparkPerfTuning")
      .master("local[*]")
      .config("spark.sql.shuffle.partitions", "8")
      .config("spark.sql.adaptive.enabled", "true")
      .getOrCreate()

    val df = spark.range(0, 100000).withColumn("v", rand())
    val aggregated = df.groupBy((col("id") % 10).as("bucket")).agg(avg("v"))
    aggregated.show(5, truncate = false)

    println("Tuned shuffle partitions and AQE for small local runs to reduce overhead.")
    spark.stop()
  }
}
