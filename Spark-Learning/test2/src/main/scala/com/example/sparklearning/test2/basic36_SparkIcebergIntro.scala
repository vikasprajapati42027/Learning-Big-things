package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic36_SparkIcebergIntro {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic36_SparkIcebergIntro").master("local[*]").getOrCreate()
    println("Apache Iceberg requires adding the Iceberg runtime jar and catalog configs; see Iceberg docs for Spark 3 integration.")
    spark.stop()
  }
}
