package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic62_SparkSkewJoinHint {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic62_SparkSkewJoinHint").master("local[*]").getOrCreate()
    import spark.implicits._

    val big = spark.range(0, 100000).toDF("id")
    val dim = spark.range(0, 3).toDF("id")
    val joined = big.hint("SKEW", "id").join(dim, "id")
    joined.explain(true)
    spark.stop()
  }
}
