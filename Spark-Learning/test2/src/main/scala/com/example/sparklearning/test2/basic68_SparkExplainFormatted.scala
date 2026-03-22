package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic68_SparkExplainFormatted {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic68_SparkExplainFormatted").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = spark.range(0, 20).withColumn("g", col("id") % 3)
    df.groupBy("g").count().explain("formatted")
    spark.stop()
  }
}
