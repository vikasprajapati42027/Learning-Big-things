package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic30_SparkDeltaLikeMerge {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic30_SparkDeltaLikeMerge").master("local[*]").getOrCreate()
    import spark.implicits._

    val existing = Seq((1, "old"), (2, "keep")).toDF("id", "value")
    val updates = Seq((1, "new"), (3, "insert")).toDF("id", "value")

    val merged = existing.alias("e")
      .join(updates.alias("u"), $"e.id" === $"u.id", "fullouter")
      .select(coalesce($"u.id", $"e.id").as("id"), coalesce($"u.value", $"e.value").as("value"))

    merged.show()
    spark.stop()
  }
}
