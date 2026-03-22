package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic84_SparkAdaptiveJoinSelection {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic84_SparkAdaptiveJoinSelection")
      .master("local[*]")
      .config("spark.sql.adaptive.enabled", "true")
      .config("spark.sql.adaptive.join.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val left = spark.range(0, 100000).toDF("id")
    val right = spark.range(0, 5).toDF("id")
    left.join(right, "id").explain(true)
    spark.stop()
  }
}
