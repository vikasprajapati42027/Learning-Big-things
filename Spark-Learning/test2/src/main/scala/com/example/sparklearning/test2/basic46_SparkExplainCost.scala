package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic46_SparkExplainCost {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic46_SparkExplainCost").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 100).withColumn("v", rand())
    df.groupBy((col("id") % 5).as("bucket")).agg(avg("v")).explain("cost")
    spark.stop()
  }
}
