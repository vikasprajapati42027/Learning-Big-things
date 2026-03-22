package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic78_SparkAccumulatorDouble {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic78_SparkAccumulatorDouble").master("local[*]").getOrCreate()

    val acc = spark.sparkContext.doubleAccumulator("sumAcc")
    val rdd = spark.sparkContext.parallelize(Seq(1.5, 2.5, 3.0))
    rdd.foreach(acc.add)
    println(s"sum accumulator -> ${acc.value}")

    spark.stop()
  }
}
