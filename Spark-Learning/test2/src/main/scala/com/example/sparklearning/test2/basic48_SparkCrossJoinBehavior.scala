package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic48_SparkCrossJoinBehavior {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic48_SparkCrossJoinBehavior").master("local[*]").getOrCreate()

    spark.conf.set("spark.sql.crossJoin.enabled", "true")
    val a = spark.range(0, 2)
    val b = spark.range(0, 3)
    a.crossJoin(b).show()

    spark.stop()
  }
}
