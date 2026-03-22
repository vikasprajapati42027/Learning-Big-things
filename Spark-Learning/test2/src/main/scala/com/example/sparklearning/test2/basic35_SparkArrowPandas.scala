package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic35_SparkArrowPandas {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic35_SparkArrowPandas").master("local[*]").getOrCreate()
    println("Arrow-accelerated pandas UDFs are for PySpark; in Scala, prefer vectorized Parquet/ORC readers and Dataset encoders.")
    spark.stop()
  }
}
