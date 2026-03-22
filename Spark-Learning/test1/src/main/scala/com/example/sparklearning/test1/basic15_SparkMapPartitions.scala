package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic15_SparkMapPartitions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic15_SparkMapPartitions").master("local[*]").getOrCreate()

    val rdd = spark.sparkContext.parallelize(1 to 10, numSlices = 3)
    val counts = rdd.mapPartitions(iter => Iterator(iter.size)).collect()
    println(s"partition sizes -> ${counts.mkString(",")}")

    spark.stop()
  }
}
