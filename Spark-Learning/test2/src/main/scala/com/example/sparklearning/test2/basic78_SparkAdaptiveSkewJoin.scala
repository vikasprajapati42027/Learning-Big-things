package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic78_SparkAdaptiveSkewJoin {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic78_SparkAdaptiveSkewJoin")
      .master("local[*]")
      .config("spark.sql.adaptive.enabled", "true")
      .config("spark.sql.adaptive.skewJoin.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val fact = spark.range(0, 100000).withColumn("k", when(col("id") === 0, lit(0)).otherwise(col("id") % 10))
    val dim = spark.range(0, 10).toDF("k")
    fact.join(dim, "k").explain(true)

    spark.stop()
  }
}
