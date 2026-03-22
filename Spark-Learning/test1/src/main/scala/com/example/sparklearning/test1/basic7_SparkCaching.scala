package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic7_SparkCaching {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic7_SparkCaching").master("local[*]").getOrCreate()
    import spark.implicits._
    val df = (1 to 1000).toDF("value").cache()
    df.count()
    df.count()
    spark.stop()
  }
}
