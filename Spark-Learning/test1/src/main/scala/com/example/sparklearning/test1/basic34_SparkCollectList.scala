package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.collect_list

object basic34_SparkCollectList {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic34_SparkCollectList").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = Seq((1, "a"), (1, "b"), (2, "c")).toDF("id", "value")
    df.groupBy("id").agg(collect_list("value").as("values")).show(false)

    spark.stop()
  }
}
