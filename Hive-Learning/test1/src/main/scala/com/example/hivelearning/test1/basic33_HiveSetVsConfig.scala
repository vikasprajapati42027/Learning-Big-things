package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic33_HiveSetVsConfig {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic33_HiveSetVsConfig")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("SET hive.exec.dynamic.partition.mode").show(false)
    spark.sql("SET spark.sql.shuffle.partitions").show(false)
    spark.sql("SET -v").show(5, truncate = false)
    spark.stop()
  }
}
