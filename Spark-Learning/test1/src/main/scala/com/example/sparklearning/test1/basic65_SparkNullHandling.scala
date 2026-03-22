package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic65_SparkNullHandling {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic65_SparkNullHandling").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, null.asInstanceOf[String]), (2, "val")).toDF("id", "txt")
    df.select($"id", coalesce($"txt", lit("missing")).as("txt_filled")).show()

    spark.stop()
  }
}
