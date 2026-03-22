package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic41_SparkAnsiMode {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic41_SparkAnsiMode")
      .master("local[*]")
      .config("spark.sql.ansi.enabled", "true")
      .getOrCreate()

    import spark.implicits._
    val df = Seq( (1, 0), (2, 2) ).toDF("num", "den")
    try {
      df.withColumn("result", col("num") / col("den")).show()
    } catch {
      case e: Exception => println(s"ANSI mode threw as expected: ${e.getMessage}")
    }
    spark.stop()
  }
}
