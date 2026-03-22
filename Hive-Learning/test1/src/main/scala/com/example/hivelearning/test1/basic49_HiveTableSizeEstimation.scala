package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic49_HiveTableSizeEstimation {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic49_HiveTableSizeEstimation")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("CREATE DATABASE IF NOT EXISTS demo_db")
    spark.sql("USE demo_db")
    spark.sql("ANALYZE TABLE stats_people COMPUTE STATISTICS") // reuse from earlier if exists
    spark.sql("DESCRIBE FORMATTED stats_people").show(truncate = false)
    spark.stop()
  }
}
