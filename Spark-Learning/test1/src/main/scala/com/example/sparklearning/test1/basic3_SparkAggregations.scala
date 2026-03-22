package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic3_SparkAggregations {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic3_SparkAggregations").master("local[*]").getOrCreate()
    import spark.implicits._
    val df = Seq(("a", 1), ("a", 2), ("b", 3)).toDF("key", "value")
    df.groupBy("key").agg(sum("value").as("total"), avg("value").as("avg")).show()
    spark.stop()
  }
}
