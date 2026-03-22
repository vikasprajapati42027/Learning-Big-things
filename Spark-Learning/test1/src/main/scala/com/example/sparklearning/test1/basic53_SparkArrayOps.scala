package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic53_SparkArrayOps {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic53_SparkArrayOps").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, Seq("a", "b")), (2, Seq("c"))).toDF("id", "tags")
    df.select($"id", size($"tags").as("tag_count"), array_contains($"tags", "a").as("has_a")).show()

    spark.stop()
  }
}
