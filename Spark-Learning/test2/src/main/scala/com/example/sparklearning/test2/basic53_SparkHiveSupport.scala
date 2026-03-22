package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic53_SparkHiveSupport {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic53_SparkHiveSupport")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    println("Hive support enabled; requires hive-site.xml and warehouse dir configured if using external metastore.")
    spark.stop()
  }
}
