package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic69_SparkDatasetMapPartitions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic69_SparkDatasetMapPartitions").master("local[*]").getOrCreate()
    import spark.implicits._

    val ds = spark.range(0, 10).mapPartitions(iter => iter.map(_ * 2))
    ds.show()
    spark.stop()
  }
}
