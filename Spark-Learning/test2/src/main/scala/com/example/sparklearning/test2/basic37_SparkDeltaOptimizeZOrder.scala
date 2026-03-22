package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic37_SparkDeltaOptimizeZOrder {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic37_SparkDeltaOptimizeZOrder").master("local[*]").getOrCreate()
    println("Delta OPTIMIZE/ZORDER needs delta-core on the classpath and a Delta table; add dependency to experiment.")
    spark.stop()
  }
}
