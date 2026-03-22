package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic23_SparkBroadcastVar {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic23_SparkBroadcastVar").master("local[*]").getOrCreate()

    val factors = spark.sparkContext.broadcast(Map("a" -> 2, "b" -> 3))
    val rdd = spark.sparkContext.parallelize(Seq("a", "b", "a"))
    val scaled = rdd.map(k => k -> factors.value.getOrElse(k, 1))
    println(scaled.collect().mkString(", "))

    spark.stop()
  }
}
