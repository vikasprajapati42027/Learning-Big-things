package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic79_SparkAQECoalesce {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic79_SparkAQECoalesce")
      .master("local[*]")
      .config("spark.sql.adaptive.enabled", "true")
      .config("spark.sql.adaptive.coalescePartitions.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 100000).withColumn("g", col("id") % 50)
    df.groupBy("g").count().explain(true)
    spark.stop()
  }
}
