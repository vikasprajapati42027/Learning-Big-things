package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic70_SparkRepartitionVsCoalesce {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic70_SparkRepartitionVsCoalesce").master("local[*]").getOrCreate()

    val df = spark.range(0, 100)
    println(s"Initial partitions: ${df.rdd.getNumPartitions}")
    println(s"After repartition(10): ${df.repartition(10).rdd.getNumPartitions}")
    println(s"After coalesce(2): ${df.repartition(10).coalesce(2).rdd.getNumPartitions}")

    spark.stop()
  }
}
