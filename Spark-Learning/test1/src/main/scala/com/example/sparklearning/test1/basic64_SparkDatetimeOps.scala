package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic64_SparkDatetimeOps {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic64_SparkDatetimeOps").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq("2024-01-01", "2024-06-15").toDF("date_str")
    df.select(to_date($"date_str").as("date"), year(to_date($"date_str")).as("yr"), month(to_date($"date_str")).as("mo")).show()

    spark.stop()
  }
}
