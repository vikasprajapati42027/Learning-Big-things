package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.coalesce

object basic49_SparkCoalesceNulls {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic49_SparkCoalesceNulls").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, Some("a"), None), (2, None, Some("b"))).toDF("id", "v1", "v2")
    df.select($"id", coalesce($"v1", $"v2").as("filled")).show()

    spark.stop()
  }
}
