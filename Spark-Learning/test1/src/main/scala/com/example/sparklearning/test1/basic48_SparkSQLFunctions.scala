package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic48_SparkSQLFunctions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic48_SparkSQLFunctions").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq("Spark", "spark", "SPARK").toDF("word")
    df.select(lower($"word").as("lower"), upper($"word").as("upper"), length($"word").as("len")).show()

    spark.stop()
  }
}
