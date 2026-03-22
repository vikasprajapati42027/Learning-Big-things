package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic20_SparkDeltaBasics {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic20_SparkDeltaBasics").master("local[*]").getOrCreate()
    println("Delta Lake operations are not included by default. Add delta-core dependency to use OPTIMIZE/DELETE/MERGE/time-travel.")
    spark.stop()
  }
}
