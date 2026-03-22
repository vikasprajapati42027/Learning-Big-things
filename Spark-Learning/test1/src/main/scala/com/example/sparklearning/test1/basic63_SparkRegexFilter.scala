package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic63_SparkRegexFilter {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic63_SparkRegexFilter").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq("abc", "123", "a1b").toDF("value")
    df.filter($"value".rlike("^[a-z]+$")).show()

    spark.stop()
  }
}
