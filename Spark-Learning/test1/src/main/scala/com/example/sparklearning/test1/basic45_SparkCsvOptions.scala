package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic45_SparkCsvOptions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic45_SparkCsvOptions").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a,b"), (2, "c")).toDF("id", "payload")
    val path = "./tmp/basic45_csv"
    df.write.mode("overwrite").option("header", "true").option("quote", "\"").option("escape", "\"").csv(path)
    println(s"wrote CSV with header to $path")

    spark.stop()
  }
}
