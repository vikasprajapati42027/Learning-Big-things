package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic14_SparkAccumulator {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic14_SparkAccumulator").master("local[*]").getOrCreate()

    val acc = spark.sparkContext.longAccumulator("positiveCount")
    val rdd = spark.sparkContext.parallelize(Seq(-1, 0, 2, 5, -3))

    rdd.foreach { v => if (v > 0) acc.add(1) }
    println(s"positive numbers -> ${acc.value}")

    spark.stop()
  }
}
