package com.example.hivelearning.test1

import org.apache.spark.sql.SparkSession

object basic32_HiveSparkCatalogs {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("basic32_HiveSparkCatalogs")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()

    println("Current catalog: " + spark.catalog.currentCatalog)
    println("Databases:")
    spark.catalog.listDatabases().show(false)
    println("Tables in demo_db (if exists):")
    spark.catalog.listTables("demo_db").show(false)

    spark.stop()
  }
}
