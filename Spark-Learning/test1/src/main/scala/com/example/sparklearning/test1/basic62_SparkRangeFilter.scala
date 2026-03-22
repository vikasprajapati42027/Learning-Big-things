package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic62_SparkRangeFilter {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic62_SparkRangeFilter").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 100).toDF("n")
    df.filter($"n".between(10, 15)).show()

    spark.stop()
  }
}
