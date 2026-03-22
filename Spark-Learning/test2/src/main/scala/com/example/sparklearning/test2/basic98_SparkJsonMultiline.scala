package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic98_SparkJsonMultiline {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic98_SparkJsonMultiline").master("local[*]").getOrCreate()

    val data = """{
  ""id"": 1,
  ""name"": ""alice""
}
{
  ""id"": 2,
  ""name"": ""bob""
}
"""
    val rdd = spark.sparkContext.parallelize([data])
    val df = spark.read.option("multiline", "true").json(rdd)
    df.show()

    spark.stop()
  }
}
