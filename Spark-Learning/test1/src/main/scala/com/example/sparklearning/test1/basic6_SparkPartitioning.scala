package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic6_SparkPartitioning {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic6_SparkPartitioning").master("local[*]").getOrCreate()
    import spark.implicits._
    val df = (1 to 100).toDF("value").repartition(4)
    println(s"num partitions -> ${df.rdd.getNumPartitions}")
    spark.stop()
  }
}
