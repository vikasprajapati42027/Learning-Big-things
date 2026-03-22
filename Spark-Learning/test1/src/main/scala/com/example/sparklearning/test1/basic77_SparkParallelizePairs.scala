package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic77_SparkParallelizePairs {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic77_SparkParallelizePairs").master("local[*]").getOrCreate()

    val pairs = spark.sparkContext.parallelize(Seq(("a", 1), ("b", 2), ("a", 3)))
    val summed = pairs.reduceByKey(_ + _).collect()
    println(s"summed pairs -> ${summed.mkString(", ")}")

    spark.stop()
  }
}
