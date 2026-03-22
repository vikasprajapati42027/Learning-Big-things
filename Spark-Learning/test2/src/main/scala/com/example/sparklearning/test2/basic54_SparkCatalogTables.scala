package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic54_SparkCatalogTables {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic54_SparkCatalogTables").master("local[*]").getOrCreate()

    spark.range(0, 3).write.mode("overwrite").saveAsTable("tmp_numbers")
    spark.catalog.listTables().show(truncate = false)

    spark.stop()
  }
}
