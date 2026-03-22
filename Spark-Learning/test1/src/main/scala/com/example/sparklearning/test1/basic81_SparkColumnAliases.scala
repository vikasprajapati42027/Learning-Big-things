package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic81_SparkColumnAliases {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic81_SparkColumnAliases").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "alpha")).toDF("id", "name")
    df.select($"id".as("user_id"), $"name".as("user_name")).show()

    spark.stop()
  }
}
