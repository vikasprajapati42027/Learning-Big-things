package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic82_SparkCaseWhen {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic82_SparkCaseWhen").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, 10), (2, 3)).toDF("id", "score")
    df.select($"id", when($"score" >= 5, "pass").otherwise("fail").as("result")).show()

    spark.stop()
  }
}
