package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic67_SparkBroadcastJoinFallback {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic67_SparkBroadcastJoinFallback")
      .master("local[*]")
      .config("spark.sql.autoBroadcastJoinThreshold", -1) // disable auto broadcast
      .getOrCreate()
    import spark.implicits._

    val big = spark.range(0, 1000).toDF("id")
    val small = spark.range(0, 5).toDF("id").withColumn("label", lit("small"))
    val joined = big.join(small, "id")
    joined.explain(true)
    spark.stop()
  }
}
