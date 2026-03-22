package com.example.sparklearning.test2

import org.apache.spark.sql.SparkSession

object basic71_SparkTableCache {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("basic71_SparkTableCache").master("local[*]").getOrCreate()

    spark.range(0, 10).createOrReplaceTempView("nums")
    spark.catalog.cacheTable("nums")
    spark.sql("select count(*) from nums").show()
    spark.catalog.uncacheTable("nums")

    spark.stop()
  }
}
