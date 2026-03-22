package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic45_SparkColumnPruning {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic45_SparkColumnPruning").master("local[*]").getOrCreate()

    val df = spark.range(0, 10).withColumnRenamed("id", "user_id")
    df.select("user_id").explain(true)
    df.select("user_id").show()

    spark.stop()
  }
}
