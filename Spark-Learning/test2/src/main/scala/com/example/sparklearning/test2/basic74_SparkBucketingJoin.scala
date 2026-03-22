package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic74_SparkBucketingJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic74_SparkBucketingJoin").master("local[*]").getOrCreate()
    import spark.implicits._

    val left = spark.range(0, 20).toDF("id")
    val right = spark.range(10, 30).toDF("id")
    val joined = left.join(right.hint("MERGE"), "id")
    joined.explain(true)

    println("Hint MERGE approximates bucketed join behavior when tables share bucket columns/number.")
    spark.stop()
  }
}
