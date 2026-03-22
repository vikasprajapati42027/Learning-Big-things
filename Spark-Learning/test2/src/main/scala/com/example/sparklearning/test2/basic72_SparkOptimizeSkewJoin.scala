package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic72_SparkOptimizeSkewJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic72_SparkOptimizeSkewJoin")
      .master("local[*]")
      .config("spark.sql.adaptive.enabled", "true")
      .config("spark.sql.adaptive.skewJoin.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val big = spark.range(0, 100000).withColumn("k", when(col("id") === 0, lit(0)).otherwise(col("id")))
    val small = Seq(0L, 1L, 2L).toDF("k")
    big.join(small, "k").explain(true)
    spark.stop()
  }
}
