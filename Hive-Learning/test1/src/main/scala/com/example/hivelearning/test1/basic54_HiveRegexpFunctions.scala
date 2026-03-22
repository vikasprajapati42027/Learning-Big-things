package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic54_HiveRegexpFunctions {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic54_HiveRegexpFunctions").master("local[*]").enableHiveSupport().getOrCreate()

    spark.sql("SELECT regexp_replace('abc123', '[0-9]', '') as letters, regexp_extract('order_2024', 'order_(\\\\d+)', 1) as num").show()
    spark.stop()
  }
}
