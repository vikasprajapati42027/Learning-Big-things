package com.example.sparklearning.test1

import org.apache.spark.sql.SparkSession

object basic88_SparkSessionCatalog {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic88_SparkSessionCatalog").master("local[*]").getOrCreate()
    spark.catalog.listDatabases().show()
    spark.catalog.listTables().show()
    spark.stop()
  }
}
