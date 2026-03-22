package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic60_SparkExplainCost {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic60_SparkExplainCost").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 5).toDF("n")
    df.explain("cost")

    spark.stop()
  }
}
