package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic95_SparkConstraintPropagation {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic95_SparkConstraintPropagation")
      .master("local[*]")
      .config("spark.sql.constraintPropagation.enabled", "true")
      .getOrCreate()

    val df = spark.range(0, 20).withColumn("g", col("id") % 2)
    df.filter("g = 1").filter("id % 2 = 0").explain(true)
    spark.stop()
  }
}
