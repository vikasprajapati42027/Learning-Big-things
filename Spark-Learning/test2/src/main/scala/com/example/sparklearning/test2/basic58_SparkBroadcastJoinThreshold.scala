package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic58_SparkBroadcastJoinThreshold {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic58_SparkBroadcastJoinThreshold")
      .master("local[*]")
      .config("spark.sql.autoBroadcastJoinThreshold", 2 * 1024 * 1024)
      .getOrCreate()
    import spark.implicits._

    val facts = spark.range(0, 10000).toDF("id")
    val dims = spark.range(0, 10).toDF("id").withColumn("label", lit("small"))
    val joined = facts.join(dims, "id")
    joined.explain(true)
    spark.stop()
  }
}
