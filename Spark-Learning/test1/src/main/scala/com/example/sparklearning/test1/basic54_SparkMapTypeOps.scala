package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic54_SparkMapTypeOps {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic54_SparkMapTypeOps").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, Map("a" -> 1, "b" -> 2))).toDF("id", "metrics")
    df.select($"id", map_keys($"metrics").as("keys"), $"metrics".getItem("a").as("metric_a")).show(false)

    spark.stop()
  }
}
