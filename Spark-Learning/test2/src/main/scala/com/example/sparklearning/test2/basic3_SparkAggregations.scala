package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic3_SparkAggregations {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic3_SparkAggregations").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq(("east", 10), ("east", 5), ("west", 2)).toDF("region", "units")
    df.groupBy("region").agg(sum("units").as("total"), avg("units").as("avg")).show()

    spark.stop()
  }
}
