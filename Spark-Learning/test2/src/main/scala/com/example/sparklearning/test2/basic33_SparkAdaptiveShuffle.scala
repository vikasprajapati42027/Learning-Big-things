package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic33_SparkAdaptiveShuffle {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic33_SparkAdaptiveShuffle")
      .master("local[*]")
      .config("spark.sql.adaptive.enabled", "true")
      .config("spark.sql.adaptive.coalescePartitions.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 100000).withColumn("bucket", col("id") % 3)
    val agg = df.groupBy("bucket").agg(sum("id").as("sum_id"))
    agg.explain(true)
    agg.show()

    spark.stop()
  }
}
