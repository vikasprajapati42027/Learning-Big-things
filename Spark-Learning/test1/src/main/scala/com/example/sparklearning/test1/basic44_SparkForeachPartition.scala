package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic44_SparkForeachPartition {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic44_SparkForeachPartition").master("local[*]").getOrCreate()

    val rdd = spark.sparkContext.parallelize(1 to 8, numSlices = 2)
    rdd.foreachPartition { iter =>
      println(s"partition handled ${iter.toList}")
    }

    spark.stop()
  }
}
