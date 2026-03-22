package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic81_SparkJoinStrategyHints {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic81_SparkJoinStrategyHints").master("local[*]").getOrCreate()
    import spark.implicits._

    val left = spark.range(0, 50).toDF("id")
    val right = spark.range(0, 5).toDF("id")

    left.join(right.hint("SHUFFLE_REPLICATE_NL"), "id").explain(true)
    spark.stop()
  }
}
