package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object basic12_SparkPartitioning {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic12_SparkPartitioning").master("local[*]").getOrCreate()
    import spark.implicits._

    val df = (1 to 100).toDF("id")
    println(s"Default partitions: ${df.rdd.getNumPartitions}")

    val wide = df.repartition(8)
    println(s"After repartition(8): ${wide.rdd.getNumPartitions}")

    val narrow = wide.coalesce(2)
    println(s"After coalesce(2): ${narrow.rdd.getNumPartitions}")

    val rangePart = df.repartitionByRange(4, col("id"))
    println(s"Range repartition(4) partitions: ${rangePart.rdd.getNumPartitions}")

    spark.stop()
  }
}
