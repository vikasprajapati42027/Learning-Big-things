package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic15_SparkExplainAQE {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic15_SparkExplainAQE")
      .master("local[*]")
      .config("spark.sql.adaptive.enabled", "true")
      .config("spark.sql.adaptive.coalescePartitions.enabled", "true")
      .getOrCreate()
    import spark.implicits._

    val left = (1 to 20).toDF("id").withColumn("v", lit("left"))
    val right = Seq(1, 2, 3).toDF("id").withColumn("v", lit("right_small"))

    val joined = left.join(right, "id")
    joined.explain(true)
    joined.show()

    spark.stop()
  }
}
